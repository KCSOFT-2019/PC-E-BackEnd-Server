package com.xuste.service.impl;

import com.xuste.dao.FormDao;
import com.xuste.pojo.Form;
import com.xuste.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormServiceImpl implements FormService {
	@Autowired
	private FormDao dao;


	@Override
	public boolean addOne(Form form) {
		return dao.addOne(form) == 1;
	}

	@Override
	public boolean deleteOne(long formId) {
		return dao.deleteOne(formId) == 1;
	}

	@Override
	public List<Form> selectManyByUserNumber(long userNumber) {
		return dao.selectManyByUserNumber(userNumber);
	}

	@Override
	public Form updateOne(Form form) {
		if (dao.updateOne(form) == 1) {
			return dao.selectOneByFormId(form.getId());
		}
		return null;
	}

	@Override
	public Form selectOneByFormId(long formId) {
		return dao.selectOneByFormId(formId);
	}
}
