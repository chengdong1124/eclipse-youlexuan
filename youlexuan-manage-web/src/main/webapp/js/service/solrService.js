//服务层
app.service('solrService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.importSolr=function(){
		return $http.get('../solr/importSolr.do');		
	}
	this.deleteSolr=function(){
		return $http.get('../solr/deleteSolr.do');		
	}
	
});















