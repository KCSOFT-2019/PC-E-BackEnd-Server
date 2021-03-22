package com.xuste.service.impl;

import com.xuste.dao.UserDao;
import com.xuste.pojo.User;
import com.xuste.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao dao;

	@Override
	public boolean canLogin(User user) {
		if (dao.selectCount(user) == 1) {

		}

		return false;
	}

	@Override
	public boolean isRegistered(User user) {
		if (dao.selectCount(user) >= 1) {
			return false;
		} else {
			dao.addOne(user);
		}
		return true;
	}
}
