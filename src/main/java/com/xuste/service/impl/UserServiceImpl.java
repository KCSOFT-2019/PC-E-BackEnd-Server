package com.xuste.service.impl;

import com.xuste.dao.UserDao;
import com.xuste.pojo.User;
import com.xuste.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao dao;

	private boolean canLogin(long userNumber) {
		return dao.selectCount(userNumber) == 1;
	}

	@Override
	public boolean login(long userNumber) {
		return canLogin(userNumber);
	}

	@Override
	public boolean isRegistered(long user) {
		if (dao.selectCount(user) >= 1) {
			return false;
		} else {
			dao.addOne(user);
		}
		return true;
	}

	@Override
	public User getOneByUserNumber(long UserNumber) {
		return dao.selectOneByUserNumber(UserNumber);
	}
}
