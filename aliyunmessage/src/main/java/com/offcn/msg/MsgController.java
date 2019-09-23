package com.offcn.msg;

import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

public class MsgController {

	public static void main(String[] args) {
		DefaultProfile profile = DefaultProfile.getProfile("default", "LTAIAdvMtHWlDXEO", "z9Pjq0uiiB4qth5n9wLgCEUT5exLTS");
		IAcsClient client = new DefaultAcsClient(profile);

		CommonRequest request = new CommonRequest();
		request.setMethod(MethodType.POST);
		request.setDomain("dysmsapi.aliyuncs.com");
		request.setVersion("2017-05-25");
		request.setAction("SendSms");
		request.putQueryParameter("RegionId", "default");
		request.putQueryParameter("PhoneNumbers", "17756382819");
		request.putQueryParameter("SignName", "此项目当为玄幻");
		request.putQueryParameter("TemplateCode", "SMS_169505336");
		request.putQueryParameter("TemplateParam", "{\"code\":\"666666\"}");
		try {
			CommonResponse response = client.getCommonResponse(request);
			
			System.out.println(response.getData());
			
			String data = response.getData();
			
			Map map = JSON.parseObject(data, Map.class);
			
			String code = (String) map.get("Code");
			
			if (code.equals("OK")) {
				
				System.out.println("发送成功");
				
			}

		} catch (ServerException e) {
			e.printStackTrace();
		} catch (ClientException e) {
			e.printStackTrace();
		}
	}
}
