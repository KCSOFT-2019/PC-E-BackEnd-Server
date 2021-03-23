package com.xuste.dao;

import com.xuste.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao {
	int selectCount(long userNumber);
	int addOne(long user);
	User selectOneByUserNumber(long userNumber);
}
