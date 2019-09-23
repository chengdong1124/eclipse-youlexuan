app.controller('solrController' ,function($scope,$controller,solrService){
	
	$controller('baseController',{$scope:$scope});//继承
	
	$scope.importSolr=function(){
		solrService.importSolr().success(function(response){
			if(response.success){
				alert(response.msg);
			}else{
				alert(response.msg);
			}
		});
	}
	
	$scope.deleteSolr=function(){
		solrService.deleteSolr().success(function(response){
			if(response.success){
				alert(response.msg);
			}else{
				alert(response.msg);
			}
		});
	}
	
});