package com.xuste.controller;


import com.xuste.config.jwt.UserLoginToken;
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
@CrossOrigin
public class FormController {
	@Autowired
	private FormService service;

	@GetMapping("/{userNumber}")
	@UserLoginToken
	public List<Form> getFormList(@PathVariable("userNumber") long userNumber) throws NullValueFoundException {
		if (service.selectManyByUserNumber(userNumber).size() == 0) {
			throw new NullValueFoundException();
		}

		return service.selectManyByUserNumber(userNumber);
	}

	@PostMapping("/addOne")
	@ResponseStatus(HttpStatus.OK)
	@UserLoginToken
	public void addForm(@RequestBody Form form) {
		service.addOne(form);
	}

	@DeleteMapping("/delete/{formId}")
	@UserLoginToken
	public void deleteForm(@PathVariable("formId") long formId) throws NullValueFoundException {
		if (!service.deleteOne(formId)) {
			throw new NullValueFoundException();
		}
	}

	@PutMapping("/updateStatus/{formId}")
	@UserLoginToken
	public Form updateStatus(@PathVariable("formId") long formId,
	                         @RequestBody Form form) throws NullValueFoundException {
		form.setId(formId);
		form = service.updateOne(form);
		if (form == null) {
			throw new NullValueFoundException();
		}
		return form;
	}
}
