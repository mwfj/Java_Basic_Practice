package mwfj.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


/**
 * Servlet 的生命周期：
 * 1 Servlet的初始化：
 * 1） Web 应用部署后，第一次客户端访问到你的这个Servlet的时候初始化
 * 2）可以通过配置，让Servlet在容器启动的时候就启动
 * 
 * 2 Servlet的生命：只要Web应用不停止（容器不停止），Servlet对象一直存在，等待着
 * 客户端的请求
 * 3 Servlet的销毁：Web应用停止（容器停止的时候），Servlet对象销毁。
 * @author RICO
 * 
 * Servlet是单例（创建后被保存在Web上，容器中）
 * 单例---》为了提高性能（不可能一次请求就创建一个对象为它服务然后销毁，这样资源销毁过大）
 * 单例也有需要注意的问题。
 *
 */
@WebServlet(urlPatterns="/login.action", loadOnStartup=1)
public class LoginServlet implements Servlet {

	/**
	 * 销毁的方法
	 */
	@Override
	public void destroy() {
		System.out.println("--destroy--");
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	/**
	 * 初始化方法
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("--init--");
	}

	/**
	 * 主方法
	 */
	@Override
	public void service(ServletRequest sRequest, ServletResponse sResponse)
			throws ServletException, IOException {
		System.out.println("--service--");
		
		PrintWriter out = null ;
		try {
			out = sResponse.getWriter();
			out.print("Welcome to my Servlet Application.");
		} finally {
			if(out != null) {
				out.close();
			}
		}
		
//		javax.servlet.GenericServlet g;
	}

}
