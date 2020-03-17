package mwfj.demo.ajax.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import mwfj.demo.entities.Student;

/**
 * Servlet implementation class CheckedRegisterNameServlet
 */
@WebServlet("/chekedRegisterName.action")
public class CheckedRegisterNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckedRegisterNameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String registerName = request.getParameter("RegisterName");
		System.out.println(registerName);
		
		boolean isRegister = false;
		if(registerName.equalsIgnoreCase("tom") || registerName.equalsIgnoreCase("jack")) {
			isRegister = true;
		}
		
//		Student student = new Student(101L, "钢铁侠", 20);
		/**
		 * json 
		 * {
		 * 		"id" :
		 * 		"name" :
		 * 		"age"
		 * }
		 */
		// JSON 工具讲对象转换成为jsonString
//		JSONObject obj = new JSONObject(student);
		
		List<Student> students = new ArrayList<Student>();
		students.add(new Student(1L, "张三", 10));
		students.add(new Student(2L, "李四", 20));
		students.add(new Student(3L, "王五", 30));
		
		/**
		 * json
		 * [ 
		 * 		{}, {}, {}
		 * ]
		 */
		
		JSONArray array = new JSONArray(students);
		
	
		
		// 响应
		PrintWriter out = null;
		try {
			// 乱码
			//response.setContentType("text/html;charset=UTF-8");
			response.setContentType("application/json;charset=UTF-8");
			out = response.getWriter();
			//out.print(isRegister);
			//out.print(obj.toString());
			out.print(array.toString());
		} finally {
			out.close();
		}
	}

}
