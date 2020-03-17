package com.Admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Admin.vo.Merchant;
import com.Admin.vo.MerchantPager;
import com.Admin.vo.User;
import com.Admin.vo.UserPager;

public class GetOneMerchantServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id_str = request.getParameter("id");
		int id = 0;
		if(id_str != null) {
			id = Integer.parseInt(id_str);
		}
		MerchantPager merchantPager = (MerchantPager) request.getSession().getAttribute("merchantPager");
		Map merchantMap = merchantPager.getMerchantMap();
		Merchant merchant = (Merchant) merchantMap.get(id);
		request.setAttribute("merchant", merchant);
		request.getRequestDispatcher("Admin/pages/manageDetailMerchant.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
