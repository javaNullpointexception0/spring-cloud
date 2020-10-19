package com.lzj.service.impl;

import java.util.List;

import brave.Span;
import brave.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.cloud.sleuth.annotation.SpanTag;
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
	@Autowired
	private Tracer tracer;

	@Override
	public List<Dept> list() {
		List<Dept> list = deptMaper.list();
		annotationSpan();
		codingSpan();
		return list;
	}

	@NewSpan(name = "annotation-span")
	private void annotationSpan() {
		System.out.println("注解方式创建span");
	}

	private void codingSpan() {
		Span newSpan = tracer.nextSpan().name("coding-span");
		try (Tracer.SpanInScope ws = tracer.withSpanInScope(newSpan.start())) {
			//对span增加标签
			newSpan.tag("tag-test", "我是一个标签");
		} finally {
			//span可以跨多个方法，只要没有调用finish，就可以通过tracer.currentSpan()获取到当前线程内的一个span
			newSpan.finish();
		}
	}
	
	@Override
	public Dept findOne(Long id) {
		return deptMaper.findOne(id);
	}

	@Override
	public int add(Dept dept) {
		return deptMaper.add(dept);
	}
}
