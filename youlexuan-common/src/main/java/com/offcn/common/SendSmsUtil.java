package com.offcn.common;

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

public class SendSmsUtil {

	public static boolean sendSms(String accessKeyId,String secret,String phone,
			String name,String templateCode,String templateParam) {

		DefaultProfile profile = DefaultProfile.getProfile("default", accessKeyId,secret);
		
		IAcsClient client = new DefaultAcsClient(profile);

		CommonRequest request = new CommonRequest();
		request.setMethod(MethodType.POST);
		request.setDomain("dysmsapi.aliyuncs.com");
		request.setVersion("2017-05-25");
		request.setAction("SendSms");
		request.putQueryParameter("RegionId", "default");
		request.putQueryParameter("PhoneNumbers", phone);
		request.putQueryParameter("SignName", name);
		request.putQueryParameter("TemplateCode", templateCode);
		request.putQueryParameter("TemplateParam", "{\"code\":\""+templateParam+"\"}");
		try {
			CommonResponse response = client.getCommonResponse(request);

			System.out.println(response.getData());

			String data = response.getData();

			Map map = JSON.parseObject(data, Map.class);

			String code = (String) map.get("Code");

			if (code.equals("OK")) {

				return true;

			}else {
				return false;
			}

		} catch (ServerException e) {
			e.printStackTrace();
		} catch (ClientException e) {
			e.printStackTrace();
		}
		return false;
	}
}