package mwfj.demo.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class RegisterServlet extends GenericServlet {
	
	private static final long serialVersionUID = -8454741902987024199L;
	
	
	@Override
	public void init() throws ServletException {
		System.out.println("--init--");
		
		String value = this.getInitParameter("Admin");
		System.out.println(value);
	}
	
	
	private ServletConfig config;

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		super.init(config);
	}




	@Override
	public void service(ServletRequest sRequest, ServletResponse sResponse)
			throws ServletException, IOException {
		System.out.println("--service--");
		
		this.config.getInitParameter("Name");
		
	
		
		
	}

}
