package com.chebat.passwordvalidator.extensions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StringVerifier
{
	@Autowired
	private CharVerifier Char;

	public Boolean HasLegnthVerifier(String password)
	{
		if (password.length() >= 9)
			return true;
		return false;
	}

	public Boolean HasDigitVerifier(String password)
	{
		for (int i = 0; i < password.length(); i++)
		{
			if (Character.isDigit(password.charAt(i)))
			{
				return true;
			}
		}
		return false;
	}

	public Boolean HasUppercaseVerifier(String password)
	{
		for (int i = 0; i < password.length(); i++)
		{
			if (Character.isUpperCase(password.charAt(i)))
			{
				return true;
			}
		}
		return false;
	}

	public Boolean HasLowercaseVerifier(String password)
	{
		for (int i = 0; i < password.length(); i++)
		{
			if (Character.isLowerCase(password.charAt(i)))
			{
				return true;
			}
		}
		return false;
	}
	
	public Boolean HasSpecialCharVerifier(String password)
	{
		for (int i = 0; i < password.length(); i++)
		{
			if (Char.HasSpecialChar(password.charAt(i)))
			{
				return true;
			}
		}
		return false;
	}
	
	public Boolean HasCharRepetitionVerifier(String password)
	{
		for(int i = 0; i < password.length(); i++)
		{
			Character value = password.charAt(i);
			for(int j = 0; j  < password.length(); j++)
			{
				if(i!=j)
					if(value == password.charAt(j))
						return true;
			}
		}
		return false;
	}
	
	public Boolean HasSpaceVerifier(String password)
	{
		for(int i = 0; i < password.length(); i++)
		{
			if(Character.isWhitespace(password.charAt(i)))
				return true;
		}
		return false;
	}
}
