package com.situ.mybatis.entity;

public class Course {
	private Integer id;
	private String name;
	private Integer credit;
	private Clazz courseList;

	public Clazz getCourseList() {
		return courseList;
	}

	public void setCourseList(Clazz courseList) {
		this.courseList = courseList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", credit=" + credit
				+ ", courseList=" + courseList + "]";
	}

}
