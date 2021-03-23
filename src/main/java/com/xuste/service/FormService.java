package com.xuste.service;

import com.xuste.pojo.Form;

import java.util.List;

public interface FormService {
	boolean addOne(Form form);
	boolean deleteOne(Form form);
	List<Form> selectManyByUserNumber(long userNumber);
}
