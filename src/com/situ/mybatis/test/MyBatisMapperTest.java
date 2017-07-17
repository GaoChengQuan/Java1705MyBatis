package com.situ.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.situ.mybatis.dao.impl.StudenDaoImpl;
import com.situ.mybatis.entity.Student;
import com.situ.mybatis.mapper.StudentMapper;

public class MyBatisMapperTest {
	SqlSessionFactory sqlSessionFactory;
	@Before
	public void before() throws IOException {
		// 加载核心配置文件
		String resource = "mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建SqlSessionFactory
		sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
	}

	@Test
	public void testFindById() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//IStudentDao studentDao = new StudenDaoImpl();
		StudentMapper studentDao = sqlSession.getMapper(StudentMapper.class);
		List<Student> list = studentDao.findAll();
		for (Student student : list) {
			System.out.println(student);
		}
		sqlSession.close();
	}
	
	@Test
	public void testFindById1() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//IStudentDao studentDao = new StudenDaoImpl();
		StudentMapper studentDao = sqlSession.getMapper(StudentMapper.class);
		List<Student> list = studentDao.findAll();
		for (Student student : list) {
			System.out.println(student);
		}
		sqlSession.close();
	}
}
