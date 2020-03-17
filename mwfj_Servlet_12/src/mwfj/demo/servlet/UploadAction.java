package mwfj.demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@MultipartConfig
@WebServlet("/upload.action")
public class UploadAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Part part = request.getPart("fileUpload");
		String fileName = part.getHeader("content-disposition");
		fileName = fileName.substring(fileName.indexOf("filename=") + 10, fileName.length() - 1);
		fileName = fileName.substring(fileName.lastIndexOf("\\") + 1, fileName.length());
		System.out.println(fileName);
		
		part.write("D:\\" + fileName);
		
	}

}
