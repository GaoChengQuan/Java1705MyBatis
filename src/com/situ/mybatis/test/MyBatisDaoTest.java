package com.situ.mybatis.test;

import org.junit.Test;

import com.situ.mybatis.dao.impl.StudenDaoImpl;
import com.situ.mybatis.entity.Student;
import com.situ.mybatis.mapper.StudentMapper;

public class MyBatisDaoTest {

	@Test
	public void testFindById() {
		StudentMapper studentDao = new StudenDaoImpl();
		Student student = studentDao.findById(1);
		System.out.println(student);
		
	}
}
