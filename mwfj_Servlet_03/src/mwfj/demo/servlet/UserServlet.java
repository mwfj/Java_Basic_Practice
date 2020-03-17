package mwfj.demo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserServlet
 * 1)
 * /user/add
 * /user/del
 *  /user/select
 * /user/update
 * 
 * 2)
 *  /user/doUser?type=add
 *  /user/doUser?type=del
 *  /user/doUser?type=select
 *  /user/doUser?type=update
 * 
 */
@WebServlet("/user/*")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		if(type != null) {
			switch (type) {
			case "add":
				
				break;
			case "del":
				
				break;

			default:
				break;
			}
		}
	}

}
