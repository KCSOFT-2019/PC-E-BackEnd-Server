package com.xuste.controller;


import com.xuste.config.jwt.UserLoginToken;
import com.xuste.pojo.Evaluation;
import com.xuste.service.EvaluationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("evaluation")
@Api("EvaluationController")
@CrossOrigin
public class EvaluationController {
	@Autowired
	private EvaluationService service;

	@PostMapping("/add/{formId}")
	@UserLoginToken
	public void addEvaluation(@PathVariable("formId") long formId,
	                           @RequestBody Evaluation evaluation) {
		evaluation.setFormId(formId);

	}

	@DeleteMapping("/delete/{formId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@UserLoginToken
	public void deleteEvaluation(@PathVariable("formId") long formId,
	                             @RequestBody Evaluation evaluation) {
		evaluation.setFormId(formId);
		service.deleteOne(evaluation);
	}

	@GetMapping("/user/getAll/{userNumber}")
	@UserLoginToken
	public List<Evaluation> getEvaluationsByUserNumber(@PathVariable("userNumber") long userNumber) {
//		service.selectManyByUsername()
		return service.selectManyByUserNumber(userNumber);
	}

	@GetMapping("/solver/getAll/{solverNumber}")
	@UserLoginToken
	public List<Evaluation> getEvaluationBySolverNumber(@PathVariable("solverNumber") long solverNumber) {
		return service.selectManyBySolverNumber(solverNumber);
	}
}
