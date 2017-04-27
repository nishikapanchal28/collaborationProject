package com.niit.CollaborationBackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDao;
import com.niit.model.User;

public class UserTestCase {
public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		UserDao userDao = (UserDao)context.getBean("userDao");
		User user = (User)context.getBean("user");
		System.out.println("Object Created");
		
		context.close();
	}
}
