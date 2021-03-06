app.controller("baseController", function($scope) {

	$scope.paginationConf = {
		currentPage : 1, // 默认是第一页
		totalItems : 100, // 总条目
		itemsPerPage : 10, // 默认没页的数据
		perPageOptions : [ 5, 10, 15, 20 ],
		onChange : function() {
			$scope.reloadList(); // 刷新页面
		}
	}

	//那就不调用search方法了吧，直接调用reloadList
	$scope.reloadList = function() {
		$scope.search($scope.paginationConf.currentPage,
				$scope.paginationConf.itemsPerPage);
	}

	$scope.selectIds = [];
	$scope.selectedId = function($event, id) {
		if ($event.target.checked) {
			$scope.selectIds.push(id);
		} else {
			var idx = $scope.selectIds.indexOf(id);//这里面还可以直接调用indexOf方法
			$scope.selectIds.splice(idx, 1);//这个地方要写个1
		}
		console.log($scope.selectIds);
	}
	
	//搞定json
	$scope.jsonToString = function(jsonstr,key){
		var json = JSON.parse(jsonstr);//把json字符串变成json对象，应该是变成了一个集合包有对象
		var value="";
		//把对象便利出来，在变成字符串
		for(var i = 0 ;i < json.length;i++){
			if(i > 0){
				value += ",";
			}
			value += json[i][key];
		}
		return value;
	}
	
	//从集合中根据key去获取数据
	$scope.searchByKey=function(list,key,keyValue){
		for (var i = 0; i < list.length; i++) {
			if(list[i][key]==keyValue){
				return list[i];
			}
		}
		return null;
	}
	
})



















