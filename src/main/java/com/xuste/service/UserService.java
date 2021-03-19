package com.xuste.service;

import com.xuste.pojo.User;

public interface UserService {
	boolean isLogin(User user);
	boolean isRegistered(User user);
}
