 //控制层 
app.controller('searchController' ,function($scope,$location,$controller,searchService){	
	
	$controller('baseController',{$scope:$scope});//继承
	
	
	//获取前台门户首页的查询条件，然后调用solr的查询方法
	$scope.getKeySearch=function(){
		$scope.searchMap.key = $location.search()["key"];
		$scope.search();
	}
	
	
	//$scope.searchMap={"key":""}
    //读取列表数据绑定到表单中  
	$scope.search=function(){
		$scope.searchMap.pageNo= parseInt($scope.searchMap.pageNo);
		searchService.search($scope.searchMap).success(
			function(response){
				$scope.resultMap=response;
				$scope.buildPageLabel();
				console.log($scope.resultMap);
			}			
		);
	}    
	
	//根据分类，品牌，规格来条件查询数据
	$scope.searchMap={"key":"","category":"","brand":"","spec":{},"price":"",
			'pageNo':1,'pageSize':5,"sort":"","sortFile":""};
	
	// 添加查询条件
	$scope.addSearchItem = function (key,value) {
		if(key == 'category' || key == 'brand' || key == 'price'){
            $scope.searchMap[key] = value;
		}else{
            $scope.searchMap.spec[key] = value;
		}
		
		$scope.search();
		console.log($scope.searchMap);
    }
	
	$scope.removeSearchItem=function(key){
		if(key == 'brand' || key == 'category' || key == 'price'){
			$scope.searchMap[key]=""
		}else{
			delete $scope.searchMap.spec[key];
		}
		$scope.search();
	}
	
	//$scope.searchMap={"totalPages":""};
	$scope.resultMap={"totalPages":""};
	//构建分页标签(totalPages为总页数)
	$scope.buildPageLabel=function(){
		$scope.pageLabel=[];//新增分页栏属性		
		var maxPageNo= $scope.resultMap.totalPages;//得到最后页码
		var firstPage=1;//开始页码
		var lastPage=maxPageNo;//截止页码		
		
		$scope.firstDot=true;//前面有点
		$scope.lastDot=true;//后边有点

		if($scope.resultMap.totalPages> 5){  //如果总页数大于5页,显示部分页码		
			if($scope.searchMap.pageNo<=3){//如果当前页小于等于3
				lastPage=5; //前5页
				
				$scope.firstDot=false;//前面没点
				
			}else if( $scope.searchMap.pageNo>=lastPage-2  ){//如果当前页大于等于最大页码-2
				firstPage= maxPageNo-4;		 //后5页	
				
				$scope.lastDot=false;//后边没点
				
			}else{ //显示当前页为中心的5页
				firstPage=$scope.searchMap.pageNo-2;
				lastPage=$scope.searchMap.pageNo+2;			
			}
		}else{
			
			$scope.firstDot=false;//前面无点
			$scope.lastDot=false;//后边无点

		}	
		//循环产生页码标签				
		for(var i=firstPage;i<=lastPage;i++){
			$scope.pageLabel.push(i);				
		}		
	}
	
	$scope.queryByPage=function(pageNo){
		//页码验证
		if(pageNo<1 || pageNo>$scope.resultMap.totalPages){
			return;
		}		
		$scope.searchMap.pageNo=pageNo;			
		$scope.search();
	}
	
	$scope.isTopPage=function(){
		if($scope.searchMap.pageNo==1){
			return true;
		}else{
			return false;
		}
	}
	
	//判断当前页是否未最后一页
	$scope.isEndPage=function(){
		if($scope.searchMap.pageNo==$scope.resultMap.totalPages){
			return true;
		}else{
			return false;
		}
	}

	//升降序
	//第一个参数：升降序的字段，SORT/DESC
	$scope.searchSort=function(sort,sortFile){
		//把参数封装到searchMap中
		$scope.searchMap.sortFile=sortFile;
		$scope.searchMap.sort=sort;
		$scope.search();
	}

	
});	












