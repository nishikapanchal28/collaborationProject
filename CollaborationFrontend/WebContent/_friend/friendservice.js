app.factory('FriendService',function($http){
	var blogService={}
	var BASE_URL="http://localhost:9191/BackendProject"
	
	blogService.getAllUsers=function(){
		return $http.get(BASE_URL + "/getAllUsers")
	}	
	blogService.sendFriendRequest=function(username){
		return $http.put(BASE_URL + "/friendRequest"+ username)
	}	
	blogService.pendingRequests=function(){
		return $http.get(BASE_URL + "/pendingRequests")
	}	
	blogService.updatependingrequest=function(from,status){
		return $http.put(BASE_URL + "/updatependingrequest/"+from+"/"+status)
	}	
	
		
	return friendService;
})