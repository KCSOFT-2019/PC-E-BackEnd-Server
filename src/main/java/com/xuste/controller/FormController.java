package com.xuste.controller;


import com.alibaba.fastjson.JSONObject;
import com.xuste.config.jwt.UserLoginToken;
import com.xuste.exception.NullValueFoundException;
import com.xuste.pojo.Form;
import com.xuste.pojo.User;
import com.xuste.service.FormService;
import com.xuste.service.UserService;
import com.xuste.service.impl.TokenServiceImpl;
import io.swagger.annotations.Api;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/form")
@Api("FormController")
@CrossOrigin
public class FormController {
	@Autowired
	private FormService service;
	@Autowired
	private UserService userService;


	@GetMapping
	@UserLoginToken
	public List<Form> getFormList(@RequestHeader("Authorization") String token) throws NullValueFoundException {
		long userNumber = TokenServiceImpl.getStuNumber(token);
		User user = userService.getOneByUserNumber(userNumber);
		List<Form> list = new ArrayList<>();
		if (user.getAuthority() == 1) {
			return service.selectAll();
		} else {
			list = service.selectManyByUserNumber(userNumber);
			if (list.size() == 0)
				throw new NullValueFoundException();
			return list;
		}
	}

//	@PostMapping("/addOne")
//	@ResponseStatus(HttpStatus.OK)
//	@UserLoginToken
//	public void addForm(@RequestBody Form form) {
//		service.addOne(form);
//	}

	@DeleteMapping("/delete")
	@UserLoginToken
	public void deleteForm(@RequestParam("q") long formId) throws NullValueFoundException {
//		long id = Long.parseLong(formId);
		if (!service.deleteOne(formId)) {
			throw new NullValueFoundException();
		}
	}

//	@DeleteMapping("/deleteList")
//	@UserLoginToken
//	public void deleteAny(@RequestBody JSONObject object,
//	                      @RequestHeader("")) {
//
//	}

	/**
	 * 可以选择上传图片和上传状态
	 * @param formId
	 * @param form
	 * @return
	 * @throws NullValueFoundException
	 */
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

	@SneakyThrows
	@PostMapping(value = "/addOne")
	@UserLoginToken
	@CrossOrigin
	public void getFile(@RequestParam("file") MultipartFile file,
	                    @RequestParam("type") String fixType,
	                    @RequestParam("description") String description,
	                    @RequestHeader("Authorization") String token) {
		User user = userService.getOneByUserNumber(TokenServiceImpl.getStuNumber(token));
		Form form = new Form();
//		MultipartFile file = (MultipartFile) object.get("file");
//		String fixType = object.getString("type");
//		String description = object.getString("description");



		form.setFixType(fixType);
		form.setDescription(description);
		form.setUserNumber(user.getUserNumber());
		form.setUserId(user.getId());
		form.setUserName(user.getName());
		form.setUserPhone(user.getUserPhone());


		File file1 = new File("E:\\ideaProjects\\XUSTE-Project\\src\\main\\resources\\pictures\\",
				Objects.requireNonNull(file.getResource().getFilename()));
		file.transferTo(file1);
		//设置图片路径
		form.setPictureUrl("pictures/" + file.getResource().getFilename());

		service.addOne(form);
	}
}
