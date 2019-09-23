//服务层
app.service('userService',function($http){
	    	
	//增加 
	this.addUser=function(entity){
		return  $http.post('../user/add.do',entity );
	}
	
	this.getCode=function(phone){
		return  $http.get('../user/getCode.do?phone='+phone);
	}

});















