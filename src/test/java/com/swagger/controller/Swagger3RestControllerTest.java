package com.swagger.controller;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.swagger.model.User;

public class Swagger3RestControllerTest {
	
	
	Swagger3RestController swagger3RestController;
	
	@Before
	public void init() {
		swagger3RestController = new Swagger3RestController();
	}
	
	@Test
	public void testGender() {
		
		String response = swagger3RestController.getGender('o');
		Assert.assertEquals("Other", response);
		
	}
	
	@Test
	public void testUsers() {
		
		List<User> users = swagger3RestController.getUsers();
		Assert.assertEquals(4, users.size());
		
	}

}
