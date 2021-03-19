package com.xuste.controller;

import com.xuste.pojo.Statement;
import com.xuste.pojo.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/")
public class LoginController {
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
	public Statement loginCheck(@RequestBody User user) {




		return new Statement();
	}

}
