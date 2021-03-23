package com.xuste.pojo;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class ResponseMessage {
	/**
	 * 请求状态信息
	 */
	private String message;
	/**
	 * 请求状态码
	 */
	private int status;
	/**
	 * error
	 */
	private String error;
	/**
	 * path
	 */
	private String path;
	/**
	 * timestamp
	 */
	private Date timestamp;
	/**
	 * token
	 */
	private String Authorization;
}
