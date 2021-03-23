package com.xuste.dao.test;

import com.xuste.DemoApplication;
import com.xuste.dao.LogDao;
import com.xuste.pojo.Log;
import com.xuste.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.mockito.Mockito.mock;

//@RunWith(SpringRunner.class)
//@AutoConfigureMybatis
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest(classes = DemoApplication.class)
class LogDaoTest {
	@Autowired
	LogDao dao;

	private Log getLog() {
		return new Log(1,
				1,
				2,
				"fuckyou");
	}

	private User getUser() {
		return new User("wangzisfa",
				11221,
				"wzh2001",
				0);
	}

	@Test
	@Rollback(false)
	public void addOneTest() {
		dao.addOne(getLog());
	}

	@Test
	@Rollback(false)
	public void deleteOne() {
		Log log = new Log();
		log.setFormId(1);
		log.setUserNumberFrom(1);
		log.setUserNumberTo(2);
		log.setChat("fuckyou");

		dao.deleteOne(log);
	}

	@Test
	public void selectManyByUser() {

	}
}
