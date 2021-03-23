package com.xuste.dao;

import com.xuste.pojo.Evaluation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface EvaluationDao {
	int addOne(Evaluation evaluation);
	int deleteOne(Evaluation evaluation);
	List<Evaluation> selectManyByUsername(long userNumber);
	List<Evaluation> selectManyBySolverName(long solverNumber);
}
