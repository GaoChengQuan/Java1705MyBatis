package com.situ.mybatis.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.situ.mybatis.entity.Student;
import com.situ.mybatis.mapper.StudentMapper;

public class StudenDaoImpl implements StudentMapper {
	SqlSessionFactory sqlSessionFactory;

	public StudenDaoImpl() {
		// 加载核心配置文件
		String resource = "mybatis.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 创建SqlSessionFactory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Override
	public Student findById(int id) {
		// 创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 执行sql语句
		Student student = sqlSession.selectOne("student.findById", 18);
		System.out.println(student);
		sqlSession.close();
		return student;
	}

	@Override
	public List<Student> findAll() {
		// 创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 执行sql语句
		List<Student> list = sqlSession.selectOne("student.findAll");
		sqlSession.close();
		return list;
	}

	@Override
	public List<Student> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
