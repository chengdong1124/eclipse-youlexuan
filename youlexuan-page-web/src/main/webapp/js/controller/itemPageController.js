 //内容分类控制层 
app.controller('itemPageController' ,function($scope,$http,$controller){	
	
	$controller('baseController',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.addNum=function(i){
		$scope.num = $scope.num + i;
		if($scope.num < 1){
			$scope.num = 1;
		}
	}    
	
	//记录用户选择的规格,颜色
	$scope.specListItems = {};
	$scope.itemsImages = {};
	
	$scope.selectItemsImages = function(name,value){
		$scope.itemsImages[name]=value;
	}
	
	
	
	//判断用户是否选中某一颜色
	$scope.isItemsImagesSelected = function(name,value){
		if($scope.itemsImages[name] == value){
			return true;
		}else{
			return false;
		}
	}
	
	
	//用户选择颜色
	$scope.selectSpecList = function(name,value){
		$scope.specListItems[name]=value;
		$scope.searchSku();
	}
	
	
	
	//判断用户是否选中某一规格
	$scope.isSelected = function(name,value){
		if($scope.specListItems[name] == value){
			return true;
		}else{
			return false;
		}
	}
	
	//加载默认的sku信息
	$scope.loadSku = function(){
		$scope.sku = skuList[0];
		$scope.specListItems = JSON.parse(JSON.stringify($scope.sku.spec));
	}
	
	//匹配两个对象是否一致
	//k为网络制式或者机身内存
	$scope.matchObject= function(map1,map2){
		for (var k in map1) {
			if(map1[k] != map2[k]){
				return false;
			}
		}
		for(var k in map2){
			if(map2[k] != map1[k]){
				return false;
			}
		}
		
		return true;
	}
	
	
	//选择更新sku
	$scope.searchSku = function(){
		for (var i = 0; i < skuList.length; i++) {
			if($scope.matchObject(skuList[i].spec,$scope.specListItems)){
				$scope.sku = skuList[i];
				return;
			}
		}
	}
	
	$scope.addCart=function(){
		//{withCredentials:'true'}同意让cookie传递，让cookie全局有效
		$http.get("http://localhost:8092/cart/addCartToCookie.do?itemId="+$scope.sku.id+"&num="+$scope.num,{withCredentials:'true'}).success(
				function(response){
					if(response.success){
						location.href="http://localhost:8092/cart.html";
						console.log(response);
					}else{
						alert(response.msg);
					}
		});
	}
    
	
});	
















