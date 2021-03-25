package com.xuste.exception;


import com.xuste.controller.EvaluationController;
import com.xuste.controller.FormController;
import com.xuste.controller.UserLoginController;
import com.xuste.controller.LogController;
import com.xuste.exception.token.BadTokenFoundException;
import com.xuste.exception.token.NullTokenFoundException;
import com.xuste.exception.token.NullUserNumberFoundException;
import com.xuste.exception.token.UserNotFoundException;
import com.xuste.pojo.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice(assignableTypes = {FormController.class,
		UserLoginController.class,
		LogController.class,
		EvaluationController.class
})
public class ExceptionHandlerUnit {
	@Autowired
	private ResponseMessage message;

	@ExceptionHandler(NullValueFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseMessage nullValueFound() {
		message.setMessage("null value found");
		message.setStatus(404);
		message.setTimestamp(new Date());
		message.setPath("/form/");

		return message;
	}

	@ExceptionHandler(NullTokenFoundException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public ResponseMessage nullTokenFound() {
		message.setMessage("Unauthorized");
		message.setStatus(401);
		message.setTimestamp(new Date());

		return message;
	}

	@ExceptionHandler(BadTokenFoundException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public ResponseMessage badTokenFound() {
		message.setMessage("wrong token");
		message.setStatus(401);
		return message;
	}

	@ExceptionHandler(NullUserNumberFoundException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public ResponseMessage nullUserNumberFound() {
		message.setMessage("null userNumber found in token");
		message.setStatus(401);
		return message;
	}

	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public ResponseMessage UserNotFound() {
		message.setMessage("got token but no user found");
		message.setStatus(401);
		return message;
	}
}
