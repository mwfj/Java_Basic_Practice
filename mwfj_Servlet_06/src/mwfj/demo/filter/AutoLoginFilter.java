package mwfj.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class AutoLoginFilter
 */
@WebFilter("/login.jsp")
public class AutoLoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AutoLoginFilter() {
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
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		Cookie[] cookies = request.getCookies();
		String loginName = null;
		String loginPassword = null;
		
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("LoginName")) {
					loginName = cookie.getValue();
					System.out.println("登录名：" + loginName);
				}
				
				if(cookie.getName().equals("LoginPassword")) {
					loginPassword = cookie.getValue();
				}
			}
		}
		
		if(loginName != null && loginPassword != null) {
			// 直接进/login.action
			request.getRequestDispatcher("/login.action?loginName=" + loginName + "&loginPassword=" + loginPassword + "&flag=isCookie").forward(request, response);
		} else {
			// /login.jsp
			chain.doFilter(req, res);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
