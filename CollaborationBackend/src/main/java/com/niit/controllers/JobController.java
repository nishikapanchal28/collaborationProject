package com.niit.controllers;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.JobDao;
import com.niit.model.User;
import com.niit.model.Error;
import com.niit.model.Job;

@RestController
public class JobController {
	
	@Autowired
	private JobDao jobDao;
	
	@RequestMapping(value="/saveJob",method=RequestMethod.POST)
	public ResponseEntity<?> saveJob(@RequestBody Job job,HttpSession session){
		User user=(User)session.getAttribute("user");
		if(user==null){
		Error error=new Error(3,"Unauthorized user");
		return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		else{
		String role=user.getRole();
		if(role.equals("Admin")){
		job.setPostedOn(new Date());
		job.setActive(true);
		jobDao.saveJobDetails(job);
		return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else{
		Error error=new Error(4,"Access Denied");
		return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		}
	}
	@RequestMapping(value="/getAllJobs",method=RequestMethod.GET)
	public ResponseEntity<?> getAllJobs(HttpSession session){
		User user=(User)session.getAttribute("user");
		if(user==null){
		Error error=new Error(3,"Unauthorized user");
		return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		List<Job> jobs=jobDao.getAllJobDetails();
		return new ResponseEntity<List<Job>>(jobs,HttpStatus.OK);
	}

	@RequestMapping(value="/getJob/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> getJobById(@PathVariable int id,HttpSession session){
		User user=(User)session.getAttribute("user");
		if(user==null){
		Error error=new Error(3,"Unauthorized user");
		return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		Job job=jobDao.getJobById(id);
		return new ResponseEntity<Job>(job,HttpStatus.OK);
	}



}
