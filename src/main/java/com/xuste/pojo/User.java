package com.xuste.pojo;


import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "User", description = "用户信息")
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
	/**
	 * 是否为老师
	 */
	private boolean isTeacher;
	/**
	 * 学院
	 */
	private String college;
	/**
	 * 班级
	 */
	private String userClass;
	/**
	 * 年级
	 */
	private long grade;
	/**
	 * 手机号
	 */
	private long userPhone;

	public User() {
	}

	public User(String name, long userNumber, String password, int authority) {
		this.name = name;
		this.userNumber = userNumber;
		this.password = password;
		this.authority = authority;
	}
}
