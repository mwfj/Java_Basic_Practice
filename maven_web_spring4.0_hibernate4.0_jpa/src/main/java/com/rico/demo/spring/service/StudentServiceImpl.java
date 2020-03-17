package com.rico.demo.spring.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rico.demo.spring.dao.StudentDao;
import com.rico.demo.spring.entities.Student;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao studentDao;

	@Override
	public void doRegister(Student student) {
		System.out.println("--service called--");
		this.studentDao.insertStudent(student);
	}

}
