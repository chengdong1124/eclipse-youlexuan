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

	$scope.reloadList = function() {
		$scope.findPage($scope.paginationConf.currentPage,
				$scope.paginationConf.itemsPerPage);
	}

	$scope.selectIds = [];
	$scope.selectedId = function($event, id) {
		if ($event.target.checked) {
			$scope.selectIds.push(id);
		} else {
			var idx = $scope.selectIds.indexOf(id);
			$scope.selectIds.splice(idx, 1);
		}
	}
})