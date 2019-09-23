//服务层
app.service('cartService',function($http){
	    	
	//增加 
	this.findAllCart=function(){
		return  $http.get('../cart/findAllCart.do');
	}
	
	this.addGoodsToCart=function(itemId,num){
		return  $http.get('../cart/addCartToCookie.do?itemId='+itemId+"&num="+num);
	}
	
	this.goodsNum=function(cartList){
		var totalValue= {totalNum:0,totalPrice:0.00};
		for (var i = 0; i < cartList.length; i++) {
			var cart = cartList[i];
			for (var j = 0; j < cart.orderItemList.length; j++) {
				var orderItem = cart.orderItemList[j];
				totalValue.totalNum += orderItem.num;
				totalValue.totalPrice += orderItem.totalFee;
			}
		}
		return totalValue;
	}
	
	this.findAddressByUserId=function(){
		return  $http.get("../cart/findAddressByUserId.do");
	}
	
	this.addOrder=function(order){
		return  $http.post('../order/add.do',order);
	}
	

});















