package com.lzj.service;

import java.util.List;

import com.lzj.entity.Dept;
import com.lzj.entity.User;

/**
 * @datetime: 2018年7月10日 下午11:27:50
 * @author: luzhenjang
 * @description: 
 */
public interface UserService {

	public User findOne(Long id);
	
	public List<User> list();
	
	public int add(User dept);
}
