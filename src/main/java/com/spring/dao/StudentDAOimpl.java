package com.spring.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.entities.Student;
@Component("studentDao")
public class StudentDAOimpl implements StudentDAO {
	@Autowired
	private JdbcTemplate jt;
	@Override
	public int save(Student std) {
		String query = "insert into Student(id,name,city) values(?,?,?)";
		int r = this.jt.update(query, std.getId(),std.getName(),std.getCity());
		return r;
	}
	@Override
	public Student getById(int id) {
		String query = "select * from student where id=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student = this.jt.queryForObject(query, rowMapper,id);

		return student;
	}
	@Override
	public int update(Student std) {
		String query = "update Student set name=? , city=? where id=?";
		int r = this.jt.update(query, std.getName(), std.getCity(), std.getId());
		return r;		
	}
	@Override
	public int deleteById(int id) {
		String query = "delete from Student where sid=?";
		int r = this.jt.update(query,id);
		return r;		
	}
	@Override
	public List<Student> getAll() {
		String query="select * from Student";
		List<Student> students = this.jt.query(query,new RowMapperImpl());
		return students;
	}
	public JdbcTemplate getJt() {
		return jt;
	}
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	
	
}
