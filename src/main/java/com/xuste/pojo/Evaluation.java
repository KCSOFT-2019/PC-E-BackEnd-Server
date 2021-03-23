package com.xuste.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;


@Data
public class Evaluation {
	private long id;
	private long formId;
	private long userNumber;
	private long solverNumber;
	private String username;
	private String solverName;
	private String comments;
	private int level;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
}
