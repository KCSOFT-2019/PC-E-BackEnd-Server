package com.xuste.service;

import com.xuste.pojo.Evaluation;

import java.util.List;

public interface EvaluationService {
	boolean addOne(Evaluation evaluation);
	boolean deleteOne(Evaluation evaluation);

	/**
	 * 根据学号/工号 查询
	 * @param userNumber 先从get那里拿到学号/工号
	 * @return
	 */
	List<Evaluation> selectManyByUserNumber(long userNumber);
	List<Evaluation> selectManyBySolverNumber(long solverNumber);
}
