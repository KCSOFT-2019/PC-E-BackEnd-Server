package com.xuste.controller;


import com.xuste.exception.NullValueFoundException;
import com.xuste.pojo.Form;
import com.xuste.service.FormService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/form")
@Api("FormController")
public class FormController {
	@Autowired
	private FormService service;

	@GetMapping("/{userNumber}")
	public List<Form> getFormList(@PathVariable("userNumber") long userNumber) throws NullValueFoundException {
		if (service.selectManyByUserNumber(userNumber).size() == 0) {
			throw new NullValueFoundException();
		}

		return service.selectManyByUserNumber(userNumber);
	}

	@PostMapping("/addOne")
	@ResponseStatus(HttpStatus.OK)
	public void addForm(@RequestBody Form form) {
		service.addOne(form);
	}
}
