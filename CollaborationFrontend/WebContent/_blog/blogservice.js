app.factory('BlogService',function($http){
	var blogService={}
	var BASE_URL="http://localhost:9191/BackendProject"
	
	blogService.saveBlogPost=function(blog){
		return $http.post(BASE_URL + "/saveBlogPost",blog)
	}	
	blogService.getAllBlogs=function(){
		return $http.get(BASE_URL + "/list")
	}	
	blogService.getBlogPostById=function(id){
		return $http.post(BASE_URL + "/get",+id)
	}	
	blogService.addBlogComment=function(blogComment){
		return $http.post(BASE_URL + "/addComment",blogComment)
	}	
	blogService.getBlogComment=function(blogPostId){
		return $http.post(BASE_URL + "/getBlogComments",+blogPostId)
	}	
	blogService.updateApproval=function(blogPost){
		return $http.post(BASE_URL + "/updateApproval",blogPost)
	}	
		
	return blogService;
})