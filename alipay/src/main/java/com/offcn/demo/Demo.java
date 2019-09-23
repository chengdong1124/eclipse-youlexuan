package com.offcn.demo;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.alipay.api.response.AlipayTradePrecreateResponse;

public class Demo {

	public static void main(String[] args) throws Exception {
		System.out.println("haha");
		AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do","2016100100639148","MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCYBOCzYu8qFEdOFDnCg8X1sFg3iuUjZ6PlPUr7Oc2MivdeGqJy7daqr0r8ueBpYmJfXtodhVSnCwQXYVGdSQYYMVpzs5HK7pwUhaHRoik7JNG7hQE48l5WKy1rKW3ZgfCegJs2kkn8HIUOXH+gkYoXVdWP8Yn+7giGJt49021FsR9ukzrgT3eKwPpcB6IzQPrMEBcO/l4n81ALpidxoXUO+KlEpbW1Tn2/ftRmtyPS3IP6+IbYVug9cE8rnKR0sDHW2OPvRpH64IfX+xO7UjZNNR+EZ38FGq2vw0fRfgqhs6X2EkO21eQTexq98Mnf+8fmJBlnkQmtFs/vg+6BZHdhAgMBAAECggEASAVfk31Ww7/RvGsWplIZ0nmWgdH7Fxf97Rhp0rYi7OfVpC7IMdz+a+UaiLtjV2o2IurkOUI2xeERMiZ4LSUwjvuq19AGTXdYWNyquo+yKwQZnVa5KoqhKP/Rx8hb88V9Awr4/hS2movEefZWvPLW0pFm2YhckXuibDQz7GSji3VQrYYAbbohr0nif/Y2H3gZ0HZH1sVeWDCy1LW91ahQ+gjc0oxJO/5XaK8BpwipcsofPWXVxC7EI0C7ZXvTlwydGDENJ++LHMn7copE+c6Gx7aCfOVSYfGNJQmhaQ3GGDbRKyrhTaAUvj7Ohzly+fKPCfnFpzYF5G+H/boDiSqWNQKBgQDQ1oBbkdeEge0sUtN+/Dlm95KAQFcIVtGogOqhEaZZTYKBlx9inyCB5dhI/jDW4xWcQnMQHOph6bEALgyva13UHXS/0BkQRAIO/TxIKdv+vYDm948gM13eA1qsDFo4MAN+8P+it2G1P7UV/IeUMJZRR5AG5hNJLznPzcCye2E76wKBgQC6WYV0MpIsZEbMzwdy46uknL7BXh+twxb+U2U4O8R4u2cb5onH8PC4SkpvwQ6i65vIjN8cVVzOmlm/x95srlxh9JsVR+TqwvSZjMp1KN6RzzrFGZKuW19WKV0rPpZ1siHKYPaXh0VlxxaO05mGIO8sB82VnlOm5THc9NoWaH2C4wKBgQCSO0DR3cNtc5ThjnWt22tOYFjjGSpYGoLgXLTuZ+91ZMLXfzxo0Efw7UKPif4k2gnNyvHK/JRaT0qzd4tGYgXne2C+1zZVn2lZmZTWawkyzPsvv3Um9RDrXqnlAxlBcs1f290E0SfHxH5GkPdWmtcGvvdo/T3P5xOyIL6nu6EQVQKBgC6akNucgh4D/gjehdhfw99pK/OkHHwSXD/Cj3/ewqYHCCRcJX0RbsJIIhGM0KJCFjWztWCaoJky1Ns3mxLHEGeXCunpjwB/PTjhkwh17iO9Fc+RM7PTOiaMNbbI8kwA/p5kXYdL1zk67xNNLAn1VptGYE3YyMbmbu/5dElCXJFNAoGBAKJ5r4a3eSQWhh3pwm1anDa+E9uJpce+BWTsCrxbID2wSDNN/HPXNBBefIrS5pTQyjDQnNUYR2aMw4afAGD38Y5D/qMrjwRe1+OJy+1wIgcI2pzxuhQxJlGGiUUqwQBkANz9sWtZVDnkvDwuM5WYqtNjPIMV0Ou10zUqKyaUKwEY"
				,"json","GBK","MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlIPnVn9XNur29dSe+bhWbWVeHNyHBOXW22i3wH+/IXvGREO/hyIaJ3zXMg/G5k88KrCXieS+sx4TKuyX7sbtZWvvAcyWSK2SkTQL0QciWnPi0CL8YQ4NF5Ka/ALgF+tOjZHtLjTm0LtWERoAwMUxT5JD6WMORW2lfNJxae7s+kQCjKr5iPeAwwdvqM5g3W3zirniVLWatz3Az4w3sowSPSBzR8r5JcK9+SvYeZuYAynvPOLlqIWC8PyHongQCyFRL/KzaI/wF+bwlICN/wbu/VUzXDvqmfAqwy8HXlKZtC3+V1kJZ4d3bP18hAxi9ds/lNIvK0d181N0AzmIOwwCAQIDAQAB","RSA2");
		AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
		request.setBizContent("{" +
				"\"out_trade_no\":\"20150320010101001\"," +
				"\"total_amount\":88.88," +
				"\"subject\":\"Iphone6 16G\"" +
				"  }");
				AlipayTradePrecreateResponse response = alipayClient.execute(request);
				String qrCode = response.getQrCode();
				System.out.println(qrCode);
				System.out.println(response.getOutTradeNo());
				if(response.isSuccess()){
				System.out.println("调用成功");
				} else {
				System.out.println("调用失败");
				}
	}
	
	
}
