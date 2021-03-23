package com.xuste.controller;

import com.xuste.pojo.ResponseMessage;
import com.xuste.pojo.User;
import com.xuste.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/")
@Api("LoginController")
public class LoginController {
	@Autowired
	UserService service;


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
	public ResponseMessage loginCheck(@RequestBody User user) {


		return new ResponseMessage();
	}

}
