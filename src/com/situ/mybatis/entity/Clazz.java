package com.situ.mybatis.entity;

import java.util.List;

public class Clazz {
	private Integer id;
	private String name;
	private List<Student> list;

	public Clazz() {
	}

	public Clazz(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public List<Student> getList() {
		return list;
	}

	public void setList(List<Student> list) {
		this.list = list;
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

	@Override
	public String toString() {
		return "Clazz [id=" + id + ", name=" + name + ", list=" + list + "]";
	}

}
