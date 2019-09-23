 //控制层 
app.controller('successController' ,function($scope,$controller,$location){	
	
	$controller('baseController',{$scope:$scope});//继承
	
	$scope.getMoney = function(){
		return $location.search()['money'];
	}
	

});	













