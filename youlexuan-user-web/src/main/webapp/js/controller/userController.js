 //控制层 
app.controller('userController' ,function($scope,$controller,userService){	
	
	$controller('baseController',{$scope:$scope});//继承
	$scope.entity={};   //前台定义了我依然可以在这里在定义一遍，这里定义的类容，前台重新输入就会改变
								//没有输入就是undefind和""不是一回事   并不相等
	$scope.addUser=function(){	
		if($scope.entity.password != $scope.password){//这里前台都是没有写，都是undefind而不是""，从而也相等，不进if
			alert("两次输入的密码不一致");
			return;
		}
		/*if($scope.code != $scope.smsCode){
			alert("两次输入的验证码不一致");
			return;
		}*/
		if($scope.entity.username == "" || $scope.entity.username == null){
			alert("用户名不能为空");
			return;
		}
		userService.addUser($scope.entity).success(function(response){
			if(response.success){
				location.href="login.html";
			}else{
				alert(response.msg);
			}
		});
		
	}
	$scope.getCode=function(phone){
		userService.getCode(phone).success(function(response){
			if(response.success){
				$scope.code=response.msg;
			}else{
				alert(response.msg);
			}
		});
	}
	

	
});	













