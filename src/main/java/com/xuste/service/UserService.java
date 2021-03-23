package com.xuste.service;

import com.xuste.pojo.User;

public interface UserService {
	/**
	 * 测试 只使用用户账号 不管密码
	 * @param userNumber
	 * @return
	 */
	boolean login(long userNumber);
	boolean isRegistered(long user);
	User getOneByUserNumber(long UserNumber);
}
