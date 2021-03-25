package com.xuste.controller;

import com.alibaba.fastjson.JSONObject;
import com.xuste.pojo.ResponseMessage;
import com.xuste.service.TokenService;
import com.xuste.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/login")
@Api("LoginController")
@CrossOrigin
public class UserLoginController {
	@Autowired
	UserService service;

	@Autowired
	TokenService tokenService;
	/*
	* 方案一
	* 请求学校api获取当前用户信息
	* */
//	@GetMapping
//	public Statement loginCheck(@RequestBody User user) {
//
//
//		return new Statement();
//	}

	/*
	* 方案二
	* 重新导向一个登录注册界面, 独立使用数据库进行增删改查
	* */
	@PostMapping
	public ResponseMessage loginCheck(@RequestBody JSONObject object) {
		ResponseMessage message = new ResponseMessage();
		long userNumber = object.getLong("userNumber");
//		System.out.println(userNumber);
		if (service.login(userNumber)) {
			message.setMessage("success");
			message.setAuthorization(tokenService.getToken(userNumber));
			message.setStatus(200);
		} else {
			message.setMessage("error in login");
			message.setStatus(400);
		}
		return message;
	}

}
