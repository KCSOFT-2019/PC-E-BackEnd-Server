package com.xuste.pojo;


import lombok.Data;

@Data
public class User {
	/**
	 * 表中的 id
	 */
	private long id;
	/**
	 * 用户姓名
	 */
	private String name;
	/**
	 * 用户学号/工号
	 */
	private long userNumber;
	/**
	 * 用户密码
	 */
	private String password;
	/**
	 * 用户权限
	 */
	private int authority;

	public User() {
	}

	public User(String name, long userNumber, String password, int authority) {
		this.name = name;
		this.userNumber = userNumber;
		this.password = password;
		this.authority = authority;
	}
}
