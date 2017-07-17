package com.situ.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.situ.mybatis.entity.Student;

public class MyBatisTest {
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
	public void testFindById() throws IOException {
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句
		Student student = sqlSession.selectOne("student.findById", 18);
		System.out.println(student);
		sqlSession.close();
	}
	
	@Test
	public void testFindAll() throws IOException {
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句
		List<Student> list = sqlSession.selectList("student.findAll");
		for (Student student : list) {
			System.out.println(student);
		}
		sqlSession.close();
	}
	
	//根据姓名模糊查找
	@Test
	public void testFindByName() throws IOException {
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句
		List<Student> list = sqlSession.selectList("student.findByName", "高");
		for (Student student : list) {
			System.out.println(student);
		}
		sqlSession.close();
	}
	
	//插入学生
	@Test
	public void testInsert() throws IOException {
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句
		Student student = new Student();
		student.setAge(20);
		student.setBirthday(new Date());
		student.setGender("男");
		student.setName("MyBatis");
		student.setPassword("123");
		int i = sqlSession.update("student.insert", student);
		//提交
		sqlSession.commit();
		sqlSession.close();
	}
	
	//根据id删除学生
	@Test
	public void testDeleteById() throws IOException {
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句
		int i = sqlSession.delete("student.deleteById", 22);
		//提交
		sqlSession.commit();
	}
	
	//根据学生对象删除学生
	@Test
	public void testDelete() throws IOException {
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句
		Student student = sqlSession.selectOne("student.findById", 57);
		int i = sqlSession.delete("student.delete", student);
		//提交
		sqlSession.commit();
		sqlSession.close();
	}
	
	//更新学生
	@Test
	public void testUpdate() throws IOException {
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句
		Student student = new Student();
		student.setId(57);
		student.setAge(20);
		student.setBirthday(new Date());
		student.setGender("男");
		student.setName("MyBatis");
		student.setPassword("123");
		int i = sqlSession.update("student.update", student);
		//提交
		sqlSession.commit();
		sqlSession.close();
	}
}
