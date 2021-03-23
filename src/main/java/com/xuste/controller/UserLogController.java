package com.xuste.controller;


import com.xuste.config.jwt.UserLoginToken;
import com.xuste.exception.NullValueFoundException;
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
@CrossOrigin
public class UserLogController {
	@Autowired
	private LogService service;

	@PostMapping("/add/{formId}")
	@UserLoginToken
	public void addOne(@RequestBody Log log,
	                   @PathVariable("formId") long formId) {
		log.setFormId(formId);
//		System.out.println(log.toString());
		service.addOne(log);
	}

	/**
	 * 到底应该返回404还是204？
	 * @param log
	 * @param logId
	 */
	@DeleteMapping("/delete/{logId}")
	@ResponseStatus(HttpStatus.OK)
	@UserLoginToken
	public void deleteOne(@RequestBody Log log,
	                      @PathVariable("logId") long logId) throws NullValueFoundException {
		log.setId(logId);
		if (!service.deleteOne(log)) {
			throw new NullValueFoundException();
		}
	}

	@GetMapping("/get/{formId}")
	@UserLoginToken
	public List<Log> getAll(@PathVariable("formId") long formId) {
		return service.selectManyByFormId(formId);
	}
}
