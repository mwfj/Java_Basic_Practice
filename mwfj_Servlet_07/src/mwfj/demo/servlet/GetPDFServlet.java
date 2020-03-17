package mwfj.demo.servlet;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetPDFServlet
 */
@WebServlet("/getReadme.pdf")
public class GetPDFServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/pdf");
		
		InputStream in = null;
		ServletOutputStream out = null;
		
		try {
			in = new BufferedInputStream(
					new FileInputStream(new File("D:" + File.separator + "JDBC.pdf")));
			out = response.getOutputStream();
			byte[] b = new byte[1024 * 5];
			int len = 0;
			while( (len = in.read(b)) != -1 ) {
				out.write(b, 0, len);
			}
		} finally {
			if(in != null) {
				in.close();
			}
			if(out != null) {
				out.close();
			}
		}
		
		
		
	}

}
