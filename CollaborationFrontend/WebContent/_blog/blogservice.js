app.factory('BlogService',function($http){
	var blogService={}
	var BASE_URL="http://localhost:9191/BackendProject"
	
	blogService.saveBlogPost=function(blog){
		return $http.post(BASE_URL + "/saveBlogPost",blog)
	}	
		
	return blogService;
})