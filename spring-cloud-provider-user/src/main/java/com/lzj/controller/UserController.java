package com.lzj.controller;

import java.util.List;

import com.lzj.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lzj.entity.Dept;
import com.lzj.service.UserService;

/**
 * @datetime: 2018年7月10日 下午11:29:38
 * @author: luzhenjang
 * @description: 
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/findOne/{id}")
	public User findOne(@PathVariable("id") Long id) {
		return userService.findOne(id);
	}
	
	@RequestMapping("/list")
	public List<User> list() {
		return userService.list();
	}
	
	@PostMapping("/add")
	public int add(@RequestBody User user) {
		return userService.add(user);
	}
}
