package com.situ.mybatis.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.situ.mybatis.entity.Student;
import com.situ.mybatis.mapper.StudentMapper;
import com.situ.mybatis.vo.SearchVO;

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

	@Override
	public List<Student> findBySearchVO(SearchVO searchVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findByPage(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int findCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Student> findByCondition(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void dynaUpdate(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Student> findByIdArray(int[] idArray) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findByIdList(List<Integer> idList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student findInfoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findInfoByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
