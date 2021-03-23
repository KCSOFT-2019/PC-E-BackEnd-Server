package com.xuste.service.impl;

import com.xuste.dao.LogDao;
import com.xuste.pojo.Log;
import com.xuste.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LogServiceImpl implements LogService {
	@Autowired
	private LogDao dao;


	@Override
	public boolean addOne(Log log) {
		return dao.addOne(log) == 1;
	}

	@Override
	public boolean deleteOne(Log log) {
		return dao.deleteOne(log) == 1;
	}

	@Override
	public List<Log> selectManyByFormId(long formId) {
		return dao.selectManyByFormId(formId);
	}
}
