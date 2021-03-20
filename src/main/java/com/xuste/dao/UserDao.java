package com.xuste.dao;

import com.xuste.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao {
	int selectCount(User user);
	int addOne(User user);
	int selectOne(User user);
}
