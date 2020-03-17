package mwfj.demo.action;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/upload.action")
// 文件上传
@MultipartConfig
public class UploadAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String fileDes = request.getParameter("fileDes");
		String fileTitle = request.getParameter("fileTitle");
		System.out.println("文件描述：" + fileDes);
		System.out.println("文件标题：" + fileTitle);
		
		System.out.println("------------------------------");
		
		/**
		 * E:\abc\linlin.jpg
		 * linlin.jpg
		 * E:\abc\linlin.jpg
		 * 
		 * 只要linlin.jpg
		 */
		Part part = request.getPart("fileUpload");
		
		String fileName = part.getHeader("content-disposition");
		// IE浏览器（或有些浏览器）会将文件在客户端的绝对路径传上来：C:\\desk\xxx.jpg
		// 所以还要再次截取一次
		System.out.println(fileName);
		// 第一次截取
		fileName = fileName.substring(fileName.indexOf("filename=") + 10, fileName.length() - 1);
		System.out.println("上传文件名：" + fileName);
		// 第二次截取
		fileName = fileName.substring(fileName.lastIndexOf("\\") + 1, fileName.length());
		System.out.println("上传文件名：" + fileName);
		
		
		
		System.out.println("上传文件大小：" + part.getSize());
		System.out.println("上传文件的FiledName：" + part.getName());
		System.out.println("上传文件的ContentType：" + part.getContentType());
		// 保存文件方法1
//		part.write("D:\\" + fileName);
		
		// 保存文件方法2
		InputStream in = null;
		OutputStream out = null;
		try {
			 in = part.getInputStream();
			 out = new BufferedOutputStream(new FileOutputStream(new File("D:\\" + fileName)));
			System.out.println("上传文件流大小：" + in.available());
			byte[] b = new byte[1024];
			int len = 0;
			while((len = in.read(b)) != -1) {
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
