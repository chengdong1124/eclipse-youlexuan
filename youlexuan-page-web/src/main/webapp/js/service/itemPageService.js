//内容分类服务层
app.service('itemPageService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.addNum=function(){
		return $http.get('../contentCategory/findAll.do');		
	}
	
});