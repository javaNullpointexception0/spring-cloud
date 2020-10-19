package com.lzj.mapper;

import java.util.List;

import com.lzj.entity.User;
import org.apache.ibatis.annotations.Mapper;

import com.lzj.entity.Dept;

/**
 * @datetime: 2018年7月10日 下午11:21:02
 * @author: luzhenjang
 * @description: 
 */
@Mapper
public interface UserMapper {

	public User findOne(Long id);
	
	public List<User> list();
	
	public int add(User dept);
}
