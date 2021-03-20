package com.xuste.pojo;


import lombok.Data;

@Data
public class Form {
	private int id;
	private long userId;
	private long userPhone;
	private String userName;
	private long userNumber;
	private String userPosition;
	private String description;
	private String fixType;
	private String currentStatus;
	private String pictureUrl;
}
