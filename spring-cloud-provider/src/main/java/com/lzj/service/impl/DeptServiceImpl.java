package com.lzj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzj.entity.Dept;
import com.lzj.mapper.DeptMapper;
import com.lzj.service.DeptService;

/**
 * @datetime: 2018年7月10日 下午11:28:15
 * @author: luzhenjang
 * @description: 
 */
@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptMapper deptMaper;
	
	@Override
	public Dept findOne(Long id) {
		return deptMaper.findOne(id);
	}
	@Override
	public List<Dept> list() {
		return deptMaper.list();
	}
	@Override
	public int add(Dept dept) {
		return deptMaper.add(dept);
	}
}
