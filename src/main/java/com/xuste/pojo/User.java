package com.xuste.pojo;


import lombok.Data;

@Data
public class User {
	//表中的id
	private int id;
	//姓名
	private String name;
	//学号\工号
	private long stuNumber;
	//密码
	private String password;
	//权限
	private int authority;
}
