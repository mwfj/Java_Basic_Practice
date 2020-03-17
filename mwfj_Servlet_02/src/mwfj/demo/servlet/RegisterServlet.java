package mwfj.demo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 * 
 * 
 * servlet-3.0 规范
 * 1 tomcat 要求7.0+
 * 2 Dynamic Web Project Module Version 3.0+
 * 3 servlet的包要求3.0以上
 * @author RICO
 *
 */
@WebServlet("/register.action")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--post--");
		request.setCharacterEncoding("UTF-8");
		/**
		 * 接收多个值提交的
		 */
		String[] interestings = request.getParameterValues("interesting");
		if(interestings != null) {
			System.out.println("你的兴趣爱好有：");
			for (String interesting : interestings) {
				System.out.print(interesting + "\t");
				System.out.println();
			}
		}
	}

}
