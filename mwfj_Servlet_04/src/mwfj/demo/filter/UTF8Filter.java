package mwfj.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;


/**
 * 生命周期
 * 初始化：Web容器启动
 * 工作中：拦截对应的URL
 * 销毁：Web容器关闭
 * @author RICO
 *
 */

@WebFilter(urlPatterns={"/login.action", "/logout.action"}, initParams={
		@WebInitParam(name="admin", value="tomcat")
})
public class UTF8Filter implements Filter {
	
	private String value;

	@Override
	public void destroy() {
		System.out.println("Filter销毁");
		
	}

	/**
	 * Filter工作中called
	 * 
	 * /*.action
	 * 处理乱码
	 * 拦截/*.action的请求
	 */
	@Override
	public void doFilter(ServletRequest sRequest, ServletResponse sResponse,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("Filter工作");
		// 处理编码
		sRequest.setCharacterEncoding("UTF-8");
		
		System.out.println("初始化参数：" + this.value);
		/**
		 * 过滤器处理完自己的功能后
		 * 让请求继续（本身应该去哪里就去哪里）
		 */
		chain.doFilter(sRequest, sResponse);
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("Filter初始化");
		
		String value = config.getInitParameter("admin");
		System.out.println(value);
		this.value = value;
		
	}

}
