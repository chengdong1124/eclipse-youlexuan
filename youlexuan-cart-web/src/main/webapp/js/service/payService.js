//服务层
app.service('payService',function($http){
	    	
	//增加 
	this.createQrCode=function(){
		return  $http.get('../pay/create.do');
	}
	
	this.queryPayStatus=function(orderId){
		return  $http.get('../pay/query.do?orderId='+orderId);
	}

});















