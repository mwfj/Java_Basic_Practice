package mwfj.demo.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/upload.action")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--上传--");
		// 乱码解决无效
//		request.setCharacterEncoding("UTF-8");
		
//		String fileDes = request.getParameter("fileDes");
//		System.out.println(fileDes);
//		ServletInputStream in = request.getInputStream();
//		System.out.println(in.available());
		
		/**
		 * 第三方的工具：fileUpload
		 * apache 
		 * Struts2 用的它
		 * jar: 
		 * commons-fileupload-1.3.1.jar
		 * commons-io-2.4.jar
		 * 
		 * 我们出发目的：request对象丢给这个工具
		 * 让它帮我们来解析数据
		 * 1 上传文件（二进制数据）
		 * 2 普通文本（字符）
		 */
		
		// 检查这次请求是否是复杂性的表单提交（里面包含File二进制数据）
		boolean isMultipartData = ServletFileUpload.isMultipartContent(request);
		
		if(isMultipartData) {
			/**
			 * 准备工作
			 * 1） 划分缓冲区
			 * 2）设置上传的一些限制
			 */
//			FileItemFactory factory = new DiskFileItemFactory();
			// 实现类的声明，可以个构造给值，也可以setter方法给值
//			DiskFileItemFactory factory = new DiskFileItemFactory();
//			// 定制一个缓冲区
//			File temp = new File("C:\\temp");
//			if(!temp.exists()) {
//				temp.mkdir();
//			}
//			factory.setRepository(temp);
//			factory.setSizeThreshold(1024 * 100);
			
			File temp = new File("C:\\temp");
			if(!temp.exists()) {
				temp.mkdir();
			}
			// 接口声明，给两个值，只能在构造的时候给
			FileItemFactory factory = new DiskFileItemFactory(1024 * 100, temp);
			// ServletUpload 对象（工长对象挂钩）
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			upload.setHeaderEncoding("UTF-8");
			// 设置单个上传文件的大小，单位是字节
			upload.setFileSizeMax(1024 * 1024 * 5);
			// 设置所有上传文件的总大小，单位是字节
			upload.setSizeMax(1024 * 1024 * 10);
			// 然后把request对象丢给upload对象解析（所有的数据都在request中）
			
			InputStream in = null;
			OutputStream out  = null;
			
			try {
				// 所有的数据都被解析后封装到List集合里面
				// FiltItem 对象代表的你提交的一个数据（可能是二进制数据，也有可能是普通数据）
				List<FileItem> fileItems =  upload.parseRequest(request);
				if(fileItems != null) {
					for(FileItem fileItem : fileItems) {
						// 区分两种数据呢？
						if(fileItem.isFormField()) {
							// 普通数据
							String fieldName = fileItem.getFieldName();
							if(fieldName.equals("fileDes")) {
								String value = fileItem.getString();
								value = new String(value.getBytes("ISO-8859-1"), "UTF-8");
								System.out.println("文件描述：" + value);
							} else if(fieldName.equals("fileTitle")) {
								String value = fileItem.getString();
								value = new String(value.getBytes("ISO-8859-1"), "UTF-8");
								System.out.println("文件标题：" + value);
							} else {
								
							}
						} else {
							// 二进制数据
							String fileName = fileItem.getName();
							System.out.println("上传文件的名：" + fileName);
							// 写文件1)
							fileItem.write(new File("D:\\" + fileName));
							
							// 写文件2)
//							 in = fileItem.getInputStream();
//							 out  = new BufferedOutputStream(new FileOutputStream(new File("D:\\" + fileName)));
//							byte[] b = new byte[1024];
//							int len = 0;
//							while((len = in.read(b)) != -1) {
//								out.write(b, 0, len);
//							}
						}
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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

}
