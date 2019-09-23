package com.offcn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.offcn.common.PhoneFormatCheckUtils;
import com.offcn.common.Result;
import com.offcn.common.SendSmsUtil;
import com.offcn.common.SmsCodeUtil;
import com.offcn.pojo.TbUser;
import com.offcn.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/add")
	public Result registerUser(@RequestBody TbUser user) {
		try {
			List<TbUser> list = userService.findAll();
			for (TbUser tbUser : list) {
				
				//System.out.println(user.getUsername());null   如果前台没有写，就是undefind，到这就是null
				
				if(user.getUsername().equals(tbUser.getUsername())) { //到这里是null的话不是个对象，不能用equals判断会报错
					return new Result(false,"用户名已被注册");
				}
			}
			boolean chinaPhoneLegal = PhoneFormatCheckUtils.isChinaPhoneLegal(user.getPhone());
			if(chinaPhoneLegal) {
				userService.addUser(user);
				return new Result(true,"注册成功");
			}else {
				return new Result(false,"手机号码不合法");
			}
		} catch (Exception e) {
			return new Result(false,"注册失败");
		}
	
		
	}
	//方案一直接通过阿里平台发短信。方案二先发送mq消息，在再spring项目中接受消息，然后发送短信
	@RequestMapping("/getCode")
	public Result getCode(String phone) {
		try {
			String code = SmsCodeUtil.getCode();
			boolean sendSms = SendSmsUtil.sendSms("LTAIAdvMtHWlDXEO", "z9Pjq0uiiB4qth5n9wLgCEUT5exLTS", 
					phone, "此项目当为玄幻", "SMS_169505336", code);
			
			if(sendSms) {
				return new Result(true,code);
			}else {
				return new Result(false,"验证码发送失败");
			}
		} catch (Exception e) {
			return new Result(false,"发送失败");
		}
	}
}
















