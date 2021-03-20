package com.xuste.pojo;


import lombok.Data;

import java.util.Date;

@Data
public class Log {
	private int id;
	private int formId;
	private long userIdFrom;
	private long userIdTo;
	private String chat;
	private Date createTime;
}
