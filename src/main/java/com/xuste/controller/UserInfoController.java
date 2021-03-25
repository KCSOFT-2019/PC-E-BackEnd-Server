package com.xuste.controller;


import com.xuste.exception.NullValueFoundException;
import com.xuste.pojo.User;
import com.xuste.service.TokenService;
import com.xuste.service.UserService;
import com.xuste.service.impl.TokenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class UserInfoController {
	@Autowired
	UserService service;


	@PostMapping("/update")
	public void updateUserInfo(@RequestHeader("Authorization") String token,
	                           @RequestBody User user) throws NullValueFoundException {
		if (!service.updateUserInfoByUserNumber(TokenServiceImpl.getStuNumber(token))) {
			throw new NullValueFoundException();
		}
	}

	@GetMapping
	public void getUserInfo(@RequestHeader("Authorization") String token) throws NullValueFoundException {
		if (service.getOneByUserNumber(TokenServiceImpl.getStuNumber(token)) == null) {
			throw new NullValueFoundException();
		}
	}
}
