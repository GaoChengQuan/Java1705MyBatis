package com.situ.mybatis.mapper;

import java.util.List;
import java.util.Map;

import com.situ.mybatis.entity.Student;
import com.situ.mybatis.vo.SearchVO;

public interface StudentMapper {
	//接口的方法名与StudentMapper.xml定义的方法名一致
	//参数必须要与StudentMapper.xml定义的方法参数一致
	//返回值必须要与StudentMapper.xml定义的方法返回值一致
	//StudentMapper.xml中的命名空间绑定此接口
	public Student findById(int id);
	
	public List<Student> findAll();
	
	public List<Student> findByName(String name);
	
	//一对一查询，查询学生信息和学生对应的班级信息
	public Student findInfoById(int id);
	
	//根据SearchVO条件查询
	//public List<Student> findBySearchVO(SearchVO searchVO);
	
	//将分页信息放在map里面
	public List<Student> findByPage(Map<String, Integer> map);
	
	public int delete(int id);
	
	//查询一共有多少学生
	public int findCount();
	
	public List<Student> findByCondition(Student student);
	//动态sql更新
	public void dynaUpdate(Student student);
	
	//根据多个id查询学生信息
	public List<Student> findByIdArray(int[] idArray);
	public List<Student> findByIdList(List<Integer> idList);
	public List<Student> findBySearchVO(SearchVO searchVO);
	
}
