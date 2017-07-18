package com.situ.mybatis.vo;

import java.util.List;

import com.situ.mybatis.entity.Student;

public class SearchVO {
	private int[] idArray;
	private List<Integer> idList;

	public int[] getIdArray() {
		return idArray;
	}

	public void setIdArray(int[] idArray) {
		this.idArray = idArray;
	}

	public List<Integer> getIdList() {
		return idList;
	}

	public void setIdList(List<Integer> idList) {
		this.idList = idList;
	}

	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
