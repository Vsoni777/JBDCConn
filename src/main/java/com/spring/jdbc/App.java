package com.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.dao.StudentDAO;
import com.spring.dao.StudentDAOimpl;
import com.spring.entities.Student;

public class App {
	public static void main(String[] args) {
	System.out.println("My Program started.........");
		// spring jdbc=> JdbcTemplate
		ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);

		StudentDAO studentDao = context.getBean("studentDao", StudentDAO.class);
//		INSERT
		Student student = new Student();
		student.setId(102);
		student.setName("vini");
		student.setCity("Indore");

	int result=studentDao.save(student);
	System.out.println("Result value after inserting value"+result);
		
		// UPDATE
//		
//		  Student student1=new Student(); 
//		  student1.setId(102);
//		  student1.setName("Raj Kumar"); 
//		  student1.setCity("Lucknow"); 
//		  int result1 = studentDao.change(student1); 
//		  System.out.println("data changed "+result1);
//		 

		// DELETE
//		int result = studentDao.delete(245);
//		System.out.println("deleted "+result);
//		

	//	Student student = studentDao.getStudent(101);
    //	System.out.println(student);

	/*	List<Student> students = studentDao.getAllStudents();
		for (Student s : students) {
			System.out.println(s);*/
		}
}
