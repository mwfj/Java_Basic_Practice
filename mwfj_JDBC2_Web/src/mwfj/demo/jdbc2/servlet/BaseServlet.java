package mwfj.demo.jdbc2.servlet;

import javax.servlet.http.HttpServlet;

import mwfj.demo.jdbc2.service.StudentService;
import mwfj.demo.jdbc2.service.impl.StudentServiceImpl;

public class BaseServlet extends HttpServlet {
	
	private static final long serialVersionUID = 8548207228075511500L;
	protected StudentService studentService = new StudentServiceImpl();

}
