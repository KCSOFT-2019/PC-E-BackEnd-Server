package com.xuste.controller.test;


import com.xuste.DemoApplication;
import com.xuste.controller.LoginController;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//import static org.mockito.Mockito.*;

@AutoConfigureMockMvc
@SpringBootTest(classes = DemoApplication.class)
public class LoginControllerTest {
	@Autowired
	MockMvc mvc;

	@Test
	public void func() throws Exception {
		mvc.perform(post("/login")
				.contentType("Application/json")
				//blablabla
		).andExpect(status().isOk());

	}
}
