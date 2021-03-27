package com.xuste.dao;


import com.xuste.pojo.Form;
import com.xuste.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface FormDao {
	int addOne(Form form);
	int deleteOne(long formId);
	List<Form> selectManyByUserNumber(long userNumber);
	List<Form> selectAll();
	Form selectOneByFormId(long formId);
	int updateOne(Form form);
}