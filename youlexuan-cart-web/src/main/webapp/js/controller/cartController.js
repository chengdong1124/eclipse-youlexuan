 //控制层 
app.controller('cartController' ,function($scope,$controller,cartService){	
	
	$controller('baseController',{$scope:$scope});//继承
	
	$scope.findAllCart = function(){
		cartService.findAllCart().success(function(response){
			$scope.cartList=response;
			
			//获取商品的总数与总金额
			$scope.totalValue = cartService.goodsNum($scope.cartList);
		});
	}
	
	$scope.addGoodsToCart=function(itemId,num){
		cartService.addGoodsToCart(itemId,num).success(function(response){
			$scope.findAllCart();
		});
	}
	
	
	$scope.findAddressByUserId=function(){
		cartService.findAddressByUserId().success(function(response){
			$scope.addressList=response;
			for (var i = 0; i < $scope.addressList.length; i++) {
				if($scope.addressList[i].isDefault == "1"){
					$scope.address = $scope.addressList[i];
					break;
				}
			}
		});
	}
	
	$scope.addAddress = function(entity){
		$scope.address = entity;
	}
	
	$scope.isSelectAddress = function(entity){
		if($scope.address == entity){
			return true;
		}else{
			return false;
		}
	}
	
	$scope.order = {paymentType:"1",receiverAreaName:"",receiverMobile:"",receiver:""}
	$scope.selectPayType = function(type){
		$scope.order.paymentType = type;
	}
	
	$scope.addOrder=function(){
		$scope.order.receiverAreaName = $scope.address.address;
		$scope.order.receiverMobile = $scope.address.mobile;
		$scope.order.receiver = $scope.address.contact;
		
		cartService.addOrder($scope.order).success(function(response){
			if(response.success){
				if($scope.order.paymentType == '1'){
					//支付宝支付
					location.href="pay.html";
				}else{
					//货到付款
					location.href="paysuccess.html";
				}
			}
			
		});
	}
	
	
	
	

	
});	













