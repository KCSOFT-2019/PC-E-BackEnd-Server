package com.xuste.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "Log", description = "对话信息")
public class Log {
	/**
	 * 对应 log 在数据库中的 id
	 */
	private long id;
	/**
	 * 当前对话对应表单 form 的id
	 */
	private long formId;
	/**
	 * userNumberFrom 当前用户学号/工号
	 */
	private long userNumberFrom;
	/**
	 * userNumberTo 如果没有指定私聊对象就可以不填
	 */
	private long userNumberTo;
	/**
	 * 一段消息内容
	 */
	private String chat;
	/**
	 * 当前消息发送时间
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	public Log() {
	}

	public Log(int formId, long userIdFrom, long userIdTo, String chat) {
		this.formId = formId;
		this.userNumberFrom = userIdFrom;
		this.userNumberTo = userIdTo;
		this.chat = chat;
	}
}
