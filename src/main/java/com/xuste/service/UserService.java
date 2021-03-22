package com.xuste.service;

import com.xuste.pojo.User;

public interface UserService {
	boolean canLogin(User user);
	boolean isRegistered(User user);
}
