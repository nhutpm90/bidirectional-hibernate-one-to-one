package com.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.dao.UserDAO;
import com.myapp.entity.User;

@RestController
public class UserController {

	@Autowired
	UserDAO userDAO;
	
	@RequestMapping("/users")
	public List<User> getUsers() {
		return userDAO.findAll();
	}

}
