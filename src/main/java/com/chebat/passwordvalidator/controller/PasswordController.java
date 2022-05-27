package com.chebat.passwordvalidator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chebat.passwordvalidator.interfaces.IPasswordService;

@Controller
public class PasswordController
{
	@Autowired
	private IPasswordService _service;
	
	public PasswordController(IPasswordService service) {
		_service = service;
	}
	@RequestMapping("/password")
	@ResponseBody
	public Boolean password()
	{
		var result = _service.VerifyPassword("aaaa");
		return result;
	}
}
