 //控制层 
app.controller('goodsController' ,function($scope,$controller,$location,itemCatService,goodsService){	
	
	$controller('baseController',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		goodsService.findAll().success(
			function(response){
				$scope.list=response;
			}			
		);
	}    
	
	//分页
	$scope.findPage=function(page,rows){			
		goodsService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(){
		//获取查询商家的id
		var id = $location.search()["id"];	// search()，location自带的方法，获取参数的结果
		if(id == null){
			return null;
		}
		goodsService.findOne(id).success(
			function(response){
				$scope.entity= response;
				editor.html($scope.entity.goodsDesc.introduction);
				$scope.entity.goodsDesc.itemImages = JSON.parse($scope.entity.goodsDesc.itemImages);
				$scope.entity.goodsDesc.specificationItems = JSON.parse($scope.entity.goodsDesc.specificationItems);
				$scope.entity.goodsDesc.customAttributeItems = JSON.parse($scope.entity.goodsDesc.customAttributeItems);
				
				for (var i = 0; i < $scope.entity.itemList.length; i++) {
					$scope.entity.itemList[i].spec=JSON.parse($scope.entity.itemList[i]);
				}
			}
		);				
	}
	
	 
	//批量删除 
	$scope.dele=function(){		
		//获取选中的复选框			
		goodsService.dele( $scope.selectIds ).success(
			function(response){
				if(response.success){
					$scope.reloadList();//刷新列表
					$scope.selectIds=[];
				}						
			}		
		);				
	}
	
	$scope.searchEntity={};//定义搜索对象 
	
	//搜索
	//不用的商家有不同的商品，所以在查询的时候需要根据不同的商家的id来查
	$scope.search=function(page,rows){			
		goodsService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}

    //是否启用规格
    $scope.checkStatus = function(specName,optionName){
    	var items = $scope.entity.goodsDesc.specificationItems;
    	var object = $scope.searchByKey(items,"attributeName",specName);
    	if(object == null){
    		return null;
    	}else{
    		if(object.attributeValue.indexOf(optionName) >= 0){
    			return true
    		}else{
    			return false;
    		}
    	}
    }
    
    //显示商品的状态
    $scope.status=["未审核","审核中","审核通过","审核未通过","关闭"];
    
    //显示商品的分类
    $scope.itemCatList = [];
    $scope.findItemCat = function(){
    	itemCatService.findAll().success(function(response){
    		for(var i = 0 ; i < response.length; i++ ){
    			 $scope.itemCatList[response[i].id]=response[i].name;
    		}
    	});
    }
    
    $scope.updateStatus = function(status){
    	goodsService.updateStatus($scope.selectIds,status).success(function(response){
    		$scope.selectIds = [];
    		if(response.success){
    			$scope.reloadList();
    		}else{
    			alert(response.msg);
    		}
    	});
    }
});	






























