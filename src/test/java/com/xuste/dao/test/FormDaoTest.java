package com.xuste.dao.test;


import com.xuste.DemoApplication;
import com.xuste.dao.FormDao;
import com.xuste.pojo.Form;
import com.xuste.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;


@SpringBootTest(classes = DemoApplication.class)
public class FormDaoTest {
	@Autowired
	FormDao dao;

	private Form getForm() {
		return new Form(123123123,
				"wangzisfa",
				11221,
				"xust",
				"this is another request",
				"huai le ma",
				"not fixed yet",
				"null");
	}

	private User getUser() {
		return new User("wangzisfa",
				11221,
				"wzh2001",
				0);
	}

	@Test
	public void addOneTest() {
		dao.addOne(getForm());
	}

	@Test
	public void deleteOne() {
		dao.deleteOne(getForm().getId());
	}

	@Test
	public void selectManyByUser() {
		List<Form> list = dao.selectManyByUserNumber(getUser().getUserNumber());
		System.out.println(Arrays.toString(list.toArray()));
	}

	@Test
	public void updateOneTest() {
		Form form = getForm();

		form.setId(1);
		form.setCurrentStatus("on my way!");

		dao.updateOne(form);
	}
}
