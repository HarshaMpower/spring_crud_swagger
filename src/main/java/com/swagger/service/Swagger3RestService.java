package com.swagger.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swagger.model.User;
import com.swagger.repository.Swagger3RestRepository;

@Service
@SuppressWarnings("unchecked")
public class Swagger3RestService {
	
	@Autowired
	public Swagger3RestRepository respoRepository;
	
	public String userSave(User user) {
		respoRepository.save(user);
		return "Success";
	}
	
	public void deleteUser(String userId) {
		respoRepository.delete(userId);
	}
	
	public void updateUserd(User user) {
		respoRepository.save(user);
	}
	
	public List<User> getUsers() {
		return (List<User>) respoRepository.findAll();
	}
	
	public User getUserById(int id) {
		Optional<User> userObject = respoRepository.findById(id);
		if(userObject.isPresent()) {
			return userObject.get();
		}
		return null;
	}

}
