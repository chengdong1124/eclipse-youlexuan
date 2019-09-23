app.controller("brandController",function($scope,$controller,brandService){
    		
			$controller("baseController",{$scope:$scope});
	
    		$scope.findPage=function(page,rows){
    			brandService.findPage(page,rows).success(function(response){
    				$scope.list=response.rows;
    				$scope.paginationConf.totalItems = response.total;
    			});
    		}
	    	
	    	$scope.add=function(){
	    		if($scope.entity.id == null){
	    			brandService.add($scope.entity).success(function(response){
		    			if(response.success){
		    				$scope.reloadList();
		    			}else{
		    				alert(response.msg);
		    			}
		    		});
	    		}else{
	    			brandService.update($scope.entity).success(function(response){
		    			if(response.success){
		    				$scope.reloadList();
		    			}else{
		    				alert(response.msg);
		    			}
		    		});
	    		}
	    		
	    	}
	    	
	    	
	    	$scope.findOne=function(id){
	    		brandService.findOne(id).success(function(response){
	    			$scope.entity=response;
	    		});
	    	}
	    	
	    	
	    	$scope.dele=function(){
	    		brandService.dele($scope.selectIds).success(function(response){
	    			if(response.success){
	    				$scope.reloadList();
	    			}else{
	    				alert(response.msg);
	    			}
	    		});
	    	}
    	});