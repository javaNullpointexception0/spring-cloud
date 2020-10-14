package com.lzj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lzj.entity.Dept;
import com.lzj.service.DeptService;

/**
 * @datetime: 2018年7月10日 下午11:29:38
 * @author: luzhenjang
 * @description: 
 */
@RestController
@RequestMapping("/dept")
public class DeptController {

	@Autowired
	private DeptService deptService;
	
	@RequestMapping("/findOne/{id}")
	public Dept findOne(@PathVariable("id") Long id) {
		return deptService.findOne(id);
	}
	
	@RequestMapping("/list")
	public List<Dept> list() {
		System.out.println(8001);
		return deptService.list();
	}
	
	@PostMapping("/add")
	public int add(@RequestBody Dept dept) {
		return deptService.add(dept);
	}
}
