package com.xuste.dao;


import com.xuste.pojo.Log;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface LogDao {
	int addOne(Log log);

	/**
	 * @param log 传递想要删除留言的用户的学号/工号
	 * @return 删除成功返回 1 失败返回 0
	 */
	int deleteOne(Log log);

	/**
	 * @param id 根据 form 表单 进行加载用户对话
	 * @return 返回用户对话信息
	 */
	List<Log> selectManyByFormId(long id);

	/**
	 * 根据 log 的其他信息查询 log 记录在数据库中的 id
	 * @param log
	 * @return 带有 id 的 log
	 */
//	Log selectOne(Log log);
}
