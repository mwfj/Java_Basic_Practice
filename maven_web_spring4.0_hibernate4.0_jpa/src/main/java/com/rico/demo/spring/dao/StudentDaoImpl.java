package com.rico.demo.spring.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rico.demo.spring.entities.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insertStudent(Student student) {
		System.out.println("--dao called--");
		this.sessionFactory.getCurrentSession().saveOrUpdate(student);
	}

}
