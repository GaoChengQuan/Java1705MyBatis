package com.situ.mybatis.mapper;

import java.util.List;

import com.situ.mybatis.entity.Student;

public interface StudentMapper {
	//接口的方法名与StudentMapper.xml定义的方法名一致
	//参数必须要与StudentMapper.xml定义的方法参数一致
	//返回值必须要与StudentMapper.xml定义的方法返回值一致
	//StudentMapper.xml中的命名空间绑定此接口
	public Student findById(int id);
	
	public List<Student> findAll();
	
	public List<Student> findByName(String name);
}
