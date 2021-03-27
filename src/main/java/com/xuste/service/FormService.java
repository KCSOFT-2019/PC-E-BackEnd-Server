package com.xuste.service;

import com.xuste.pojo.Form;

import java.util.List;

public interface FormService {
	boolean addOne(Form form);
	boolean deleteOne(long formId);
	List<Form> selectManyByUserNumber(long userNumber);
	List<Form> selectAll();
	Form updateOne(Form form);
	Form selectOneByFormId(long formId);
}
