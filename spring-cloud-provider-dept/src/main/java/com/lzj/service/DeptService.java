package com.lzj.service;

import java.util.List;

import com.lzj.entity.Dept;

/**
 * @datetime: 2018年7月10日 下午11:27:50
 * @author: luzhenjang
 * @description: 
 */
public interface DeptService {

	public Dept findOne(Long id);
	
	public List<Dept> list();
	
	public int add(Dept dept);
}
