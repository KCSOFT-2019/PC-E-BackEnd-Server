package com.xuste.controller;


import com.xuste.pojo.Evaluation;
import com.xuste.service.EvaluationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("evaluation")
@Api("EvaluationController")
public class EvaluationController {
	@Autowired
	private EvaluationService service;

	@PostMapping("/{formId}/add")
	public void addEvaluation(@PathVariable("formId") long formId,
	                           @RequestBody Evaluation evaluation) {
		evaluation.setFormId(formId);

	}

	@DeleteMapping("/{formId}/delete")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteEvaluation(@PathVariable("formId") long formId,
	                             @RequestBody Evaluation evaluation) {
		evaluation.setFormId(formId);
		service.deleteOne(evaluation);
	}

	@GetMapping("/{userNumber}/getAll")
	public List<Evaluation> getEvaluationsByUserNumber(@PathVariable("userNumber") long userNumber) {
//		service.selectManyByUsername()

		return new ArrayList<>();
	}
}
