package com.lzj.service.impl;

import java.util.List;

import com.lzj.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.stereotype.Service;

import com.lzj.entity.Dept;
import com.lzj.mapper.UserMapper;
import com.lzj.service.UserService;

/**
 * @datetime: 2018年7月10日 下午11:28:15
 * @author: luzhenjang
 * @description: 
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMaper;
	
	@Override
	public User findOne(Long id) {
		return userMaper.findOne(id);
	}
	@Override
	public List<User> list() {
		List<User> users = userMaper.list();
		return users;
	}
	@Override
	public int add(User user) {
		return userMaper.add(user);
	}
}
