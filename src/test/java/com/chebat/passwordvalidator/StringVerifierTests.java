package com.chebat.passwordvalidator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.chebat.passwordvalidator.extensions.StringVerifier;

@SpringBootTest
public class StringVerifierTests
{
	@Autowired
	private StringVerifier _verifier;

	@Test
	public void TestLengthVerifier()
	{
		String password = "aaabbbccc";
		var result = _verifier.HasLegnthVerifier(password);
		assertEquals(true, result);
	}

	@Test
	public void TestDigitVerifier()
	{
		String password = "aaab2bccc";
		var result = _verifier.HasDigitVerifier(password);
		assertEquals(true, result);
	}

	@Test
	public void TestUppercaseVerifier()
	{
		var password = "aaab2Bccc";
		var result = _verifier.HasUppercaseVerifier(password);
		assertEquals(true, result);
	}

	@Test
	public void TestLowercaseVerifier()
	{
		var password = "AAABBbCCC";
		var result = _verifier.HasLowercaseVerifier(password);
		assertEquals(true, result);
	}
	
	@Test
	public void TestSpecialCharVerifier()
	{
		var password = "AAABbbcc$";
		var result = _verifier.HasSpecialCharVerifier(password);
		assertEquals(true, result);
	}
	
	@Test
	public void TestCharRepetitionVerifier()
	{
		var password = "AbcA";
		var result = _verifier.HasCharRepetitionVerifier(password);
		assertEquals(true, result);
	}
	
	@Test
	public void TestSpaceVerifier()
	{
		var password = "AAA Bbbcc$";
		var result = _verifier.HasSpaceVerifier(password);
		assertEquals(true, result);
	}

}
