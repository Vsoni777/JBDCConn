package com.spring.dao;

import java.util.List;

import com.spring.entities.Student;

public interface StudentDAO {
	public int save(Student std);
	public Student getById(int id);
	public int update(Student std);
	public int deleteById(int id);
	public List<Student> getAll();
	
}
