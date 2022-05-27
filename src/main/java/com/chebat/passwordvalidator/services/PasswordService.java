package com.chebat.passwordvalidator.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chebat.passwordvalidator.extensions.StringVerifier;
import com.chebat.passwordvalidator.interfaces.IPasswordService;

@Service
public class PasswordService implements IPasswordService
{
	@Autowired
	private StringVerifier _verifier;
	
	public PasswordService()
	{
	}

	public Boolean VerifyPassword(String password)
	{
		if(	_verifier.HasLegnthVerifier(password) &&
			_verifier.HasDigitVerifier(password) &&
			_verifier.HasUppercaseVerifier(password) &&
			_verifier.HasLowercaseVerifier(password) &&
			_verifier.HasSpecialCharVerifier(password) &&
			!_verifier.HasCharRepetitionVerifier(password) &&
			!_verifier.HasSpaceVerifier(password))
		{
			return true;
		}
		return false;
	}

}
