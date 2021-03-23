package com.xuste.service;

import com.xuste.pojo.Log;

import java.util.List;

public interface LogService {
	boolean addOne(Log log);
	boolean deleteOne(Log log);
	List<Log> selectManyByFormId(long formId);
}
