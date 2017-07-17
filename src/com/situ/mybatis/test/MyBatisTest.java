package com.situ.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.situ.mybatis.entity.Student;

public class MyBatisTest {

	@Test
	public void testMyBatis() throws IOException {
		String resource = "mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Student student = sqlSession.selectOne("student.findById", 18);
		System.out.println(student);
	}
}
