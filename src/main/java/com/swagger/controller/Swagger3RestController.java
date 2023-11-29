package com.swagger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.swagger.model.User;
import com.swagger.service.Swagger3RestService;

import io.swagger.v3.oas.annotations.Operation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api")
@RestController
public class Swagger3RestController {
	
	@Autowired
	Swagger3RestService swagger3RestService;

	List<User> users = new ArrayList<User>();
	{
		users.add(new User(1,"Test-User1", "ADMIN", "user1@test.com"));
		users.add(new User(2,"Test-User2", "SUPERVISOR", "user2@test.com"));
		users.add(new User(3,"Test-User3", "USER", "user3@test.com"));
		users.add(new User(4,"Test-User4", "USER", "user4@test.com"));
	}


	@RequestMapping(value = "/getUsers", method = RequestMethod.GET, produces = "application/json")
	public List<User> getUsers() {
		//return swagger3RestService.getUsers();
		return users;
	}

	@RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET, produces = "application/json")
	public User getUserById(@PathVariable(value = "id") int id) {
		//return swagger3RestService.getUserById(id);
		return users.stream().filter(x -> x.getId()==(id)).collect(Collectors.toList()).get(0);
	}
	
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST, produces = "application/json")
	public String saveUserById(@RequestBody User user) {
		//swagger3RestService.userSave(user);
		users.add(user);
		return "user Added successfully"; 
	}

	@RequestMapping(value = "/getUser/role/{role}", method = RequestMethod.GET, produces = "application/json")
	public List<User> getUserByRole(@PathVariable(value = "role") String role) {
		//List<User> userList = swagger3RestService.getUsers();
		return users.stream().filter(x -> x.getRole().equalsIgnoreCase(role))
				.collect(Collectors.toList());
	}
	
	@RequestMapping(value = "/getUser/gender/{gender}", method = RequestMethod.GET, produces = "application/json")
	@Operation(summary = "If gender is 'm' it will return Male and if it is 'f' it will return Female else it will return Other")
	public String getGender(@PathVariable(value = "gender") char gender) {
		
		switch(gender) {
			
			case 'm' : return "Male";
			case 'f' : return "FeMale";
			default : return "Other";
		}
		
	}

}
