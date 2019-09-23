 //控制层 
app.controller('payController' ,function($scope,$controller,payService){	
	
	$controller('baseController',{$scope:$scope});//继承
	
	$scope.createQrCode=function(){
		payService.createQrCode().success(function(response){
			$scope.money=response.totalFee;
			$scope.out_trade_no=response.out_trade_no;
			
			var qr = new QRious({
				element:document.getElementById('qr'),
				size:250,
				level:'H',
				value:response.qr_code
			});
			
			$scope.queryPayStatus($scope.out_trade_no);
		});
	}
	
	$scope.queryPayStatus=function(orderId){
		payService.queryPayStatus(orderId).success(function(response){
			if(response.success){
				location.href="paysuccess.html#?money="+$scope.money;
			}else{
				if(response.msg == "过期不候"){
					document.getElementById("timeout").innerHTML("二维码过期，刷新页面重新获取");
				}
				location.href="payfail.html";
			}
		});
	}
	
	

	
});	













