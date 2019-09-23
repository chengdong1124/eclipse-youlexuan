//服务层
app.service('fileUploadService',function($http){
	
	this.fileUpload=function(){
		var formData = new FormData();
		formData.append("file",file.files[0]);
		return $http({
			method:"post",
			url:"../file/upload.do",
			data:formData,
			headers:{"Content-Type":undefined},//json格式
			transformRequest:angular.identity
		});
	}
	
});