package com.situ.mybatis.mapper;

import java.util.List;

import com.situ.mybatis.entity.Clazz;
import com.situ.mybatis.entity.Student;

public interface ClazzMapper {
	//查询id查询班级信息，包含这个班里所有学生信息
	public Clazz findClazzInfoById(int id);
	
	//查询id查询班级信息，包含这个班里所有课程信息
	public Clazz findClazzCourseInfoById(int id);
	
	//查询id查询学生信息
	public List<Student> findStudentListByName(String name);
	
	
}
