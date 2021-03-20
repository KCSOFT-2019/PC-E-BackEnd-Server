package com.xuste.dao;


import com.xuste.pojo.Log;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface LogDao {
	int addOne(@Param("log") Log log);
}
