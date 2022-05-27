package com.chebat.passwordvalidator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.chebat.passwordvalidator.services.PasswordService;

@SpringBootTest
class PasswordvalidatorApplicationTests
{

	@Autowired
	private PasswordService _service;

	@Test
	public void TestValidPasswordService()
	{
		var password = "AbTp9!fok";
		var result = _service.VerifyPassword(password);
		assertEquals(true, result);
	}

	@Test
	public void TestNullPassword()
	{
		var password = "";
		var result = _service.VerifyPassword(password);
		assertEquals(false, result);
	}

	@Test
	public void TestWrongPasswordServiceRepetition()
	{
		var password = "AbTp9!foo";
		var result = _service.VerifyPassword(password);
		assertEquals(false, result);
	}

	@Test
	public void TestWrongPasswordServiceRepetition2()
	{
		var password = "AbTp9!foA";
		var result = _service.VerifyPassword(password);
		assertEquals(false, result);
	}

	@Test
	public void TestWrongPasswordServiceRepetition3()
	{
		var password = "AbTp9!foa";
		var result = _service.VerifyPassword(password);
		assertEquals(true, result);
	}

	@Test
	public void TestWrongPasswordServiceSpace()
	{
		var password = "AbTp9 fok";
		var result = _service.VerifyPassword(password);
		assertEquals(false, result);
	}

}
