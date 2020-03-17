package mwfj.demo.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import mwfj.demo.entities.Product;

/**
 * Servlet Filter implementation class IndexFilter
 */
//@WebFilter({"/index.jsp", "/cart.jsp", "/product.jsp"})
public class IndexFilter implements Filter {

    /**
     * Default constructor. 
     */
    public IndexFilter() {
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
		
		System.out.println("--filter--");
		
		/**
		 * 预先准备数据
		 * ”多“  ---》 集合
		 * ”单“ ---》 对象
		 */
		List<Product> products = new ArrayList<Product>();
		products.add(new Product(1L, "cn0001", "苹果", 10));
		products.add(new Product(2L, "cn0002", "香蕉", 20));
		products.add(new Product(3L, "cn0003", "草莓", 30));
		products.add(new Product(4L, "cn0004", "橘子", 40));
		products.add(new Product(5L, "cn0005", "西瓜", 50));
		
		/**
		 * 存储域
		 * page 
		 * request ----》只在一次请求范围中有效
		 * session
		 * application
		 */
		request.setAttribute("products", products);
		/**
		 * 
		 */
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
