package com.chebat.passwordvalidator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chebat.passwordvalidator.interfaces.IPasswordService;
import com.chebat.passwordvalidator.models.PasswordModel;

@Controller
public class PasswordController
{
	@Autowired
	private IPasswordService _service;
	
	// public PasswordController(IPasswordService service) {
	//	_service = service;
	// }
	
	@PostMapping("/password")
	@ResponseBody
	public Boolean password(@RequestBody PasswordModel model)
	{
		var result = _service.VerifyPassword(model.password);
		System.out.println(model.password);
		return result;
	}
}
