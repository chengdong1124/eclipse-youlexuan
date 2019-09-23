app.controller("loginController",function($scope,$controller,loginService){
	
	$controller('baseController',{$scope:$scope});//继承
	
	$scope.getLoginName = function(){
		loginService.getLoginName().success(function(response){
			$scope.loginName=response.loginName;
		});
	}
})