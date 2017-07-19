package com.situ.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.situ.mybatis.dao.impl.StudenDaoImpl;
import com.situ.mybatis.entity.Clazz;
import com.situ.mybatis.entity.Course;
import com.situ.mybatis.entity.Student;
import com.situ.mybatis.mapper.ClazzMapper;
import com.situ.mybatis.mapper.StudentMapper;
import com.situ.mybatis.vo.SearchVO;

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
		Student student = studentDao.findById(18);
		System.out.println(student);
		sqlSession.close();
	}
	
	@Test
	public void testDelete() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//IStudentDao studentDao = new StudenDaoImpl();
		StudentMapper studentDao = sqlSession.getMapper(StudentMapper.class);
		int i = studentDao.delete(35);
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void testFindAll() {
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
	public void testFindBySearchVO1() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//IStudentDao studentDao = new StudenDaoImpl();
		StudentMapper studentDao = sqlSession.getMapper(StudentMapper.class);
		SearchVO searchVO = new SearchVO();
		Student student = new Student();
		student.setName("高");
		searchVO.setStudent(student);
		List<Student> list = studentDao.findBySearchVO(searchVO);
		for (Student stu : list) {
			System.out.println(stu);
		}
		sqlSession.close();
	}
	
	@Test
	public void testFindByPage() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentMapper studentDao = sqlSession.getMapper(StudentMapper.class);
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("pageIndex", 2);
		map.put("pageSize", 3);
		List<Student> list = studentDao.findByPage(map);
		for (Student stu : list) {
			System.out.println(stu);
		}
		sqlSession.close();
	}
	
	@Test
	public void testfindAll() {
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
	public void testFindCount() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//IStudentDao studentDao = new StudenDaoImpl();
		StudentMapper studentDao = sqlSession.getMapper(StudentMapper.class);
		int count = studentDao.findCount();
		System.out.println("count: " + count);
		sqlSession.close();
	}
	
	@Test
	public void testFindByCondition() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//IStudentDao studentDao = new StudenDaoImpl();
		StudentMapper studentDao = sqlSession.getMapper(StudentMapper.class);
		Student student = new Student();
		student.setName("高");
//		student.setGender("男");
		List<Student> list = studentDao.findByCondition(student);
		for (Student stu : list) {
			System.out.println(stu);
		}
		sqlSession.close();
	}
	
	@Test
	public void testDynaUpdate() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentMapper studentDao = sqlSession.getMapper(StudentMapper.class);
		Student student = new Student();
		student.setId(18);
		student.setName("Gao");
		/*student.setGender("男");
		student.setPassword("88888");*/
		/*student.setAge(30);*/
		studentDao.dynaUpdate(student);
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void testFindByIdArray() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentMapper studentDao = sqlSession.getMapper(StudentMapper.class);
		int[] idArray = {18,35,36};
		List<Student> list = studentDao.findByIdArray(idArray);
		for (Student student : list) {
			System.out.println(student);
		}
		sqlSession.close();
	}
	
	@Test
	public void testFindByIdList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentMapper studentDao = sqlSession.getMapper(StudentMapper.class);
		List<Integer> list = new ArrayList<Integer>();
		list.add(18);
		list.add(35);
		list.add(36);
		List<Student> stuList = studentDao.findByIdList(list);
		for (Student student : stuList) {
			System.out.println(student);
		}
		sqlSession.close();
	}
	
	@Test
	public void testFindBySearchVO() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentMapper studentDao = sqlSession.getMapper(StudentMapper.class);
		SearchVO searchVO = new SearchVO();
		List<Integer> list = new ArrayList<Integer>();
		list.add(18);
		list.add(35);
		list.add(36);
		searchVO.setIdList(list);
		List<Student> stuList = studentDao.findBySearchVO(searchVO);
		for (Student student : stuList) {
			System.out.println(student);
		}
		sqlSession.close();
	}
	
	
	@Test
	public void testFindInfoById() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentMapper studentDao = sqlSession.getMapper(StudentMapper.class);
		Student student = studentDao.findInfoById(18);
		System.out.println(student);
		sqlSession.close();
	}
	
	//查询id查询班级信息，包含这个班里所有学生信息
	@Test
	public void testFindClazzInfoById() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ClazzMapper clazzMapper = sqlSession.getMapper(ClazzMapper.class);
		Clazz clazz = clazzMapper.findClazzInfoById(1);
		//System.out.println(clazz);
		System.out.println("班级名称：" + clazz.getName());
		System.out.println("班级的学生信息列表：");
		List<Student> list = clazz.getList();
		for (Student student : list) {
			System.out.println(student);
		}
		sqlSession.close();
	}
	
	//查询id查询学生信息
	@Test
	public void testFindStudentListById() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ClazzMapper clazzMapper = sqlSession.getMapper(ClazzMapper.class);
		List<Student> list = clazzMapper.findStudentListByName("Java1705");
		//System.out.println(clazz);
		System.out.println("班级的学生信息列表：");
		for (Student student : list) {
			System.out.println(student);
		}
		sqlSession.close();
	}
	
	//查询id查询班级信息，包含这个班里所有课程信息
	@Test
	public void testFindClazzCourseInfoById() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ClazzMapper clazzMapper = sqlSession.getMapper(ClazzMapper.class);
		Clazz clazz = clazzMapper.findClazzCourseInfoById(1);
		System.out.println("班级的名称是："+clazz.getName());
		System.out.println("班级的课程信息列表：");
		List<Course> list = clazz.getCourseList();
		for (Course course : list) {
			System.out.println(course);
		}
		sqlSession.close();
	}
	
	//根据名字查询学生的相关信息
	@Test
	public void testFindInfoByName() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		List<Student> list = studentMapper.findInfoByName("高");
		for (Student stu : list) {
			System.out.println("学生的姓名："+stu.getName());
			System.out.println("学生的所在班级："+stu.getClazz().getName());
			List<Course> courseList = stu.getClazz().getCourseList();
			for (Course course : courseList) {
				System.out.println(course);
			}
		}
		sqlSession.close();
	}
}
