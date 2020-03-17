package mwfj.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class HackNameFilter
 */
@WebFilter("/login.action")
public class HackNameFilter implements Filter {

    /**
     * Default constructor. 
     */
    public HackNameFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String loginName = request.getParameter("loginName");
		if(loginName != null) {
			/**
			 * tom用户名是黑名单
			 * 过滤掉
			 */
			if(loginName.equalsIgnoreCase("tom")) {
				/**
				 *  阻止请求继续，响应客户端
				 *  
				 */
				HttpServletResponse res = (HttpServletResponse)response;
				HttpServletRequest req = (HttpServletRequest)request;
				// 响应
				res.sendRedirect(req.getContextPath() + "/login.jsp?errorCode=5");
				return;
			}
		}
		
		// 本来到哪里，还是去哪里
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
