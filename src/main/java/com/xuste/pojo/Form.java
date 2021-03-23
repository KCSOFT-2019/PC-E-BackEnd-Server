package com.xuste.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "Form", description = "请求表单")
public class Form {
	/**
	 * 对应数据库中 form 表的 id
	 */
	@ApiModelProperty(value = "id",
			name = "表单的 id",
			dataType = "long",
			example = "1111"
	)
	private long id;
	/**
	 * 填写表单用户的 id
	 */
	private long userId;
	/**
	 * 用户手机号
	 */
	private long userPhone;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 用户学号/工号
	 */
	private long userNumber;
	/**
	 * 用户位置信息
	 */
	private String userPosition;
	/**
	 * 问题描述
	 */
	private String description;
	/**
	 * 维修类型
	 */
	private String fixType;
	/**
	 * 当前进行状态
	 */
	private String currentStatus;
	/**
	 * 图片链接
	 */
	private String pictureUrl;
	/**
	 * 表单创建时间
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	public Form() {
	}

	public Form(long userPhone, String userName, long userNumber, String userPosition, String description, String fixType, String currentStatus, String pictureUrl) {
		this.userPhone = userPhone;
		this.userName = userName;
		this.userNumber = userNumber;
		this.userPosition = userPosition;
		this.description = description;
		this.fixType = fixType;
		this.currentStatus = currentStatus;
		this.pictureUrl = pictureUrl;
	}
}
