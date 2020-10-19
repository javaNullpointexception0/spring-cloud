package com.lzj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lzj.entity.Dept;

/**
 * @datetime: 2018年7月10日 下午11:21:02
 * @author: luzhenjang
 * @description: 
 */
@Mapper
public interface DeptMapper {

	public Dept findOne(Long id);
	
	public List<Dept> list();
	
	public int add(Dept dept);
}
