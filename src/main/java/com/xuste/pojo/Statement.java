package com.xuste.pojo;

import lombok.Data;

@Data
public class Statement {
	/**
	 * 请求状态信息
	 */
	private String message;
	/**
	 * 请求状态码
	 */
	private int code;
	/**
	 * contentType
	 */
	private String ContentType;
}
