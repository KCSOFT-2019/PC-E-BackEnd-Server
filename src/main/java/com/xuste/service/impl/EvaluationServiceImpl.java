package com.xuste.service.impl;

import com.xuste.pojo.Evaluation;
import com.xuste.service.EvaluationService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EvaluationServiceImpl implements EvaluationService {
	@Override
	public boolean addOne(Evaluation evaluation) {
		return false;
	}

	@Override
	public boolean deleteOne(Evaluation evaluation) {
		return false;
	}

	/**
	 * @param userNumber 先从get那里拿到学号/工号
	 * @return 返回的时候记得要根据用户学号添加用户姓名
	 */
	@Override
	public List<Evaluation> selectManyByUserNumber(long userNumber) {
		return null;
	}

	/**
	 * @param solverNumber
	 * @return 返回的时候记得要根据用户学号添加用户姓名
	 */
	@Override
	public List<Evaluation> selectManyBySolverNumber(long solverNumber) {
		return null;
	}
}
