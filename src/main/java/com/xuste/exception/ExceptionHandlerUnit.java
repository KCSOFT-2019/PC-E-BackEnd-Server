package com.xuste.exception;


import com.xuste.controller.FormController;
import com.xuste.controller.LoginController;
import com.xuste.controller.UserLogController;
import com.xuste.pojo.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice(assignableTypes = {FormController.class,
		LoginController.class,
		UserLogController.class
})
public class ExceptionHandlerUnit {
	@ExceptionHandler(NullValueFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseMessage nullValueFound() {
		ResponseMessage message = new ResponseMessage();
		message.setMessage("null value found");
		message.setStatus(404);
		message.setTimestamp(new Date());
		message.setPath("/form/");

		return message;
	}

}
