package com.chebat.passwordvalidator.extensions;

import org.springframework.stereotype.Service;

@Service
public class CharVerifier
{
	
	public  Boolean HasSpecialChar(Character value)
    {
        if( value == '!' || value == '@' || 
            value == '#' || value == '$' || 
            value == '%' || value == '^' || 
            value == '&' || value == '*' || 
            value == '(' || value == ')' || 
            value == '-' || value == '+')
        {
            return true;
        }
        return false;
    }
}
