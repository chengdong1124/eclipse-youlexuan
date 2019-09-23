var app = angular.module("youlexuan", []);

//告诉angularJs 允许当前的高亮显示的注入
app.filter("trustHtml",["$sce",function($sce){
	return function (data){
		return $sce.trustAsHtml(data);
	}
}]);