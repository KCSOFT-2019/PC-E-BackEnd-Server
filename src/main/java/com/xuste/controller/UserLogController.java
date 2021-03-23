package com.xuste.controller;


import com.xuste.pojo.Log;
import com.xuste.service.LogService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/log")
@Api("UserLogController")
public class UserLogController {
	@Autowired
	private LogService service;

	@PostMapping("/{formId}/add")
	public void addOne(@RequestBody Log log,
	                   @PathVariable("formId") long formId) {
		log.setFormId(formId);
//		System.out.println(log.toString());
		service.addOne(log);
	}

	@DeleteMapping("/{formId}/delete")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteOne(@RequestBody Log log,
	                      @PathVariable("formId") long formId) {
		log.setFormId(formId);
		service.deleteOne(log);
	}

	@GetMapping("/{formId}/get")
	public List<Log> getAll(@PathVariable("formId") long formId) {
		return service.selectManyByFormId(formId);
	}
}
