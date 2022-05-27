package com.chebat.passwordvalidator.services;

import org.springframework.stereotype.Service;

import com.chebat.passwordvalidator.interfaces.IPasswordService;

@Service
public class PasswordService implements IPasswordService
{

	public PasswordService()
	{
	}

	public Boolean VerifyPassword(String password)
	{
		return false;
	}

}
