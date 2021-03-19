package com.xuste.dao;


import com.xuste.pojo.Form;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface FormDao {
	int addOne(@Param("form") Form form);
	int deleteOne(@Param("form") Form form);
}
