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
 * Servlet implementation class GetImageServlet
 */
@WebServlet("/getImage.jpg")
public class GetImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 应该返回一副图片内容
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--GetImage---");
		
		String id = request.getParameter("id");
		if(id == null) {
			return;
		}
		
		
		/**
		 * 响应类型可以是任何是数据类型
		 * 默认：text/html  ----> MIME 类型
		 * 图片类型：image/jpeg
		 */
		response.setContentType("image/jpeg");
		
		/**
		 * 文件输入流
		 */
		InputStream in = null;
		/**
		 * 响应输出流
		 * 
		 */
		ServletOutputStream out = null;
		
		try {
			/**
			 * 装饰器模式
			 * new 构造方法(new 构造方法(new 构造法.....))
			 */
			in = new BufferedInputStream(new FileInputStream(new File("D:\\" + id + ".jpg")));
			/**
			 * 限定本次发回的流量总大小
			 * 
			 */
//			response.setContentLength(in.available());
			out = response.getOutputStream();
//			byte[] b = new byte[in.available()];
//			in.read(b);
//			out.write(b);
			
			// 缓冲
			byte[] b = new byte[1024];

			int len = 0;
			while((len = in.read(b)) != -1) {
				out.write(b, 0, len);
			} 
			
//			while(in.read(b)  != -1) {
//				out.write(b);
//			}
			
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
