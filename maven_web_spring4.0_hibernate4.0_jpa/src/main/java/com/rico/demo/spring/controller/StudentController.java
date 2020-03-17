package com.rico.demo.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rico.demo.spring.entities.Student;
import com.rico.demo.spring.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(Student student) {
		System.out.println("--controller--");
		System.out.println(student.getLoginName());
		System.out.println(student.getLoginPassword());
		this.studentService.doRegister(student);
		
		return null;
	}

	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public String toIndex() {
		return "index";
	}

}
