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

@WebServlet("/download.action")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("---download---");

		InputStream in = null;
		ServletOutputStream out = null;

		try {
			File file = new File("D:\\成都学院.docx");
			String fileName = file.getName();
			System.out.println(fileName);

			// 请求头中 user-agent属性信息
			String userAgent = request.getHeader("User-Agent");

			// 文件乱码处理
			/**
			 * 文件名乱码处理问题不可避免 所以，最好下载文件名不要用中文 
			 * D:\\成都学院.docx      cdxu.docx
			 */
			if (userAgent.contains("Chrome")) {
				System.out.println("Chrome 浏览器");
				fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
			} else if (userAgent.contains("Firefox")) {
				System.out.println("Firefox 浏览器");
				fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
			} else {
				// 最新IE浏览器中已经不包含MSIE的关键字
				System.out.println("IE 浏览器");
				fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
			}

			System.out.println(fileName);

			in = new BufferedInputStream(new FileInputStream(file));
			/**
			 * 设置response
			 */
			// 设置编码
			response.setCharacterEncoding("UTF-8");
			// 设置下载文件类型：二进制流文件
			response.setContentType("application/x-msdownload");
			// 设置响应里面文件的总大小
			response.setContentLength(in.available());
			// 设置响应头，以便你的客户端浏览器弹出下载保存的对话框
			response.setHeader("Content-Disposition", "attachment;filename="
					+ fileName);
			out = response.getOutputStream();
			byte[] b = new byte[1024 * 5];
			int len = 0;
			while ((len = in.read(b)) != -1) {
				out.write(b, 0, len);
			}

		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}

}
