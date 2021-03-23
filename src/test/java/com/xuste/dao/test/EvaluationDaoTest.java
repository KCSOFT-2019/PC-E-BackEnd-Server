package com.xuste.dao.test;

import com.xuste.DemoApplication;
import com.xuste.dao.EvaluationDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest(classes = DemoApplication.class)
public class EvaluationDaoTest {
	@Autowired
	private EvaluationDao dao;



	@Test
	public void selectManyByUsernameTest() {
		System.out.println(Arrays.toString(
				dao.selectManyByUsername(1111).toArray()
		));
	}

	@Test
	public void selectManyBySolverNameTest() {
		System.out.println(Arrays.toString(
				dao.selectManyBySolverName(1111).toArray()
		));
	}
}
