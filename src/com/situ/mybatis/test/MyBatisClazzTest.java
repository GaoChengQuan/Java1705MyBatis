package com.situ.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.situ.mybatis.entity.Clazz;
import com.situ.mybatis.entity.Student;

public class MyBatisClazzTest {
	SqlSessionFactory sqlSessionFactory;

	@Before
	public void before() throws IOException {
		// 加载核心配置文件
		String resource = "mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建SqlSessionFactory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindById() throws IOException {
		// 创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 执行sql语句
		Clazz clazz = sqlSession.selectOne("clazz.findById", 1);
		System.out.println(clazz);
		sqlSession.close();
	}
	
	@Test
	public void testInsert() throws IOException {
		// 创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 执行sql语句
		Clazz clazz = new Clazz();
		clazz.setName("Java1705");
		int i = sqlSession.insert("clazz.insert", clazz);
		sqlSession.commit();
		sqlSession.close();
	}
}
