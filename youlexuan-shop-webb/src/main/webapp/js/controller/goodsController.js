 //控制层 
app.controller('goodsController' ,function($scope,$controller,$location,fileUploadService,typeTemplateService,itemCatService,goodsService){	
	
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
				//$scope.entity.itemList=JOSN.parse($scope.entity.itemList);
				for (var i = 0; i < $scope.entity.itemList.length; i++) {
					$scope.entity.itemList[i].spec=JSON.parse($scope.entity.itemList[i]);
				}
			}
		);				
	}
	
	//保存 
	$scope.save=function(){
		
		var serviceObject;//服务层对象  	
		
		$scope.entity.goodsDesc.introduction=editor.html();//获取富文本编辑器的内容（前提是需要页面中初始化富文本编辑器）
		
		//因为前台传递给后台的是json数据，而在保存数据的时候，把这些数据转化成了json对象，所以在这需要在转会json字符换
		$scope.entity.goodsDesc.customAttributeItems=JSON.stringify($scope.entity.goodsDesc.customAttributeItems);
		
		$scope.entity.goodsDesc.specificationItems=JSON.stringify($scope.entity.goodsDesc.specificationItems);
		
		$scope.entity.goodsDesc.itemImages = JSON.stringify($scope.entity.goodsDesc.itemImages);
		
		if($scope.entity.goods.isEnableSpec == 1){
			
			for (var i = 0; i < $scope.entity.itemList.length; i++) {
				
				$scope.entity.itemList[i].spec=JSON.stringify($scope.entity.itemList[i].spec);
			}
		}
		
		console.log($scope.entity);
		
		if($scope.entity.goods.id!=null){//如果有ID
			serviceObject=goodsService.update( $scope.entity ); //修改  
			location.href="goods.html";
		}else{
			serviceObject=goodsService.add( $scope.entity  );//增加 
			location.href="goods.html";
		}				
		serviceObject.success(
			function(response){
				if(response.success){
					//重新查询 
		        	$scope.reloadList();//重新加载
				}else{
					alert(response.message);
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
	
	//查询一级
    $scope.selectItemCat1 = function(){
    	itemCatService.findByParentId(0).success(function(response){
    		$scope.ItemCat1List=response;
    	});
    }
    
    //查询二级
    $scope.$watch("entity.goods.category1Id",function(newValue,oldValue){
    	if(newValue){
    		itemCatService.findByParentId(newValue).success(function(response){
        		$scope.ItemCat2List=response;
        	});
    	}
    });
    
    $scope.$watch("entity.goods.category2Id",function(newValue,oldValue){
    	if(newValue){
    		itemCatService.findByParentId(newValue).success(function(response){
        		$scope.ItemCat3List=response;
        	});
    	}
    })
    
    $scope.$watch("entity.goods.category3Id",function(newValue,oldValue){
    	if(newValue){
    		itemCatService.findOne(newValue).success(function(response){
        		$scope.entity.goods.typeTemplateId=response.typeId;
        	});
    		
    	}
    })

    
     //$scope.entity={goodsDesc:{}};
	 $scope.$watch("entity.goods.typeTemplateId",function(newValue,oldValue){
		if(newValue){
			typeTemplateService.findOne(newValue).success(function(response){
	    		$scope.typeTemplate = response;
	    		//获取品牌列表
	    		$scope.typeTemplate.brandIds=JSON.parse($scope.typeTemplate.brandIds);
	    		//获取自定义属性（扩展属性）
	    		
	    		//$scope.entity.goodsDesc.customAttributeItems和回显的时候的$scope.entity.goodsDesc.customAttributeItems重合了
	    		//不知道选谁，做个判断,同时还是因为这个方法属于一级级传递的方法的原因
	    		if($location.search()["id"] == null){
	    			$scope.entity.goodsDesc.customAttributeItems = JSON.parse($scope.typeTemplate.customAttributeItems);
	    		}
			});
				
			typeTemplateService.findSpecList(newValue).success(function(response){
				$scope.speciList=response;
			});
		}
	})
    //图片上传
    $scope.image_entity={url:"",color:""};
    $scope.fileUpload = function(){
    	fileUploadService.fileUpload().success(function(response){
    		if(response.success){
    			$scope.image_entity.url=response.msg;
    		}else{
    			alert(response.msg);
    		}
    	});
    }
    
    //图片上传后的保存
    $scope.add_entity_image=function(){
    	//把图片保存到entity.goodsDesc.itemImages集合中
    	$scope.entity.goodsDesc.itemImages.push($scope.image_entity);
    }
    //图片删除
    $scope.remove_image=function(index){
    	$scope.entity.goodsDesc.itemImages.splice(index,1);
    }
    
    
    
    //获取规格列表
    $scope.entity={goods:{},goodsDesc:{itemImages:[],specificationItems:[]}};
    //console打印的是全局，所以这里有数据，源自于下面的else，console.log($scope.entity.goodsDesc.specificationItems);
    
    $scope.updateSpectionAttribute=function($event,name,value){
    	
    	var object = $scope.searchByKey($scope.entity.goodsDesc.specificationItems,"attributeName",name)
    	
    	if(object != null){
    		if($event.target.checked){
    			
    			object.attributeValue.push(value);
    			
    		}else{
    			object.attributeValue.splice(object.attributeValue.indexOf(value),1);
    			if(object.attributeValue.length==0){
    				$scope.entity.goodsDesc.specificationItems.splice($scope.entity.goodsDesc.specificationItems.indexOf(object),1);
    			}
    		}
    	}else{
    		$scope.entity.goodsDesc.specificationItems.push({"attributeName":name,"attributeValue":[value]});
    		
    	}
    }
    
    //展示选中的规格列表
    $scope.createItemList= function(){
    	$scope.entity.itemList = [{spec:{},price:0,num:100,status:'0',isDefault:'0'}];
    	
    	var items = $scope.entity.goodsDesc.specificationItems;
    	//为什么这里可以直接遍历
    	for (var i = 0; i < items.length; i++) {
    		$scope.entity.itemList = addColumn($scope.entity.itemList,items[i].attributeName,items[i].attributeValue);
    	}									//从这个list中取到格式，在下面遍历赋值
    }
    
    //添加每一列数据
    addColumn=function(list,name,value){
    	var newList = [];
    	for (var i = 0; i < list.length; i++) {
			var oldRow = list[i];
			for(var j = 0; j < value.length; j++){
				var newRow = JSON.parse(JSON.stringify(oldRow));
				newRow.spec[name]=value[j];
				newList.push(newRow);
			}
		}
    	return newList;
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
    	//var ids = $scope.selectIds;
    	
    	goodsService.updateStatus($scope.selectIds,status).success(function(response){
    		if(response.success){
    			$scope.reloadList();
    			$scope.selectIds=[];
    		}else{
    			alert(response.msg);
    		}
    	});
    }
});	






























