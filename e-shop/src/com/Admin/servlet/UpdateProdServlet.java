package com.Admin.servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Admin.dao.AdminProdDao;
import com.Admin.daoimpl.AdminProdDaoImpl;
import com.Admin.vo.Product;
import com.Admin.vo.Product_Attr;
import com.common.ImgUtil;
import com.jspsmart.upload.*;

public class UpdateProdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 新建一个SmartUpload对象
		SmartUpload su = new SmartUpload();
		//上传初始化
		su.initialize(this.getServletConfig(), request,response);
	    try {
	    	su.upload();
	    }catch (SmartUploadException e1) {
	        e1.printStackTrace();
	    }
	    ImgUtil imgUtil=new ImgUtil();
	    String imgPath=imgUtil.savePath;
		String saveFile = imgPath;
		com.jspsmart.upload.File file = su.getFiles().getFile(0);
		String myFileName=file.getFileName(); //取得上载文件的文件名
		saveFile+=myFileName;
		if(!"".equals(myFileName)){
			try {
					file.saveAs(saveFile);
			} catch (SmartUploadException e) {
			    e.printStackTrace();
			}
		}
		com.jspsmart.upload.Request req = su.getRequest();
		String prodid_str=req.getParameter("prodid");
		int prodId=0;
		if(prodid_str!=null){
			prodId=Integer.parseInt(prodid_str);
		}
		String prodName = req.getParameter("productname").trim();             //获取产品名
		String introduce = req.getParameter("introduce").trim();        //获取相关介绍
		String str_price = req.getParameter("price").trim();				//原有价格
		String str_nowPrice = req.getParameter("nowprice").trim();			//现有价格
		String str_prodNum = req.getParameter("prodnum").trim();        	//获取商品数量
		String origin=req.getParameter("origin");                   //获取来源
		String str_newProds = req.getParameter("newProds");      	//获取产品类型
		String str_saleProds = req.getParameter("saleProds");		//是否特价
		String str_hotProds = req.getParameter("hotProds");			//是否在热销
		int newProds = 0;
		int saleProds = 0;
		int hotProds = 0;
		int specialProds = 0;
		int pages = 0;
		if(str_newProds != null)	//判断是否选择类型，如果选择为1，否则为0
			newProds = Integer.parseInt(str_newProds);
		if(str_saleProds != null)
			saleProds = Integer.parseInt(str_saleProds);
		if(str_hotProds != null)
			hotProds = Integer.parseInt(str_hotProds);
		Product product = new Product();			//创建产品对象
		product.setProductid(prodId);
		product.setProductname(prodName);		//设置产品名
		product.setIntroduce(introduce);    	//设置产品介绍
		product.setOrigin(origin);	            //设置产品来源
		product.setNowprice(Double.parseDouble(str_nowPrice));	//设置现有价格
		product.setPrice(Double.parseDouble(str_price));	//设置原有价格
		product.setPicture(myFileName);		    //设置图片
		product.setIsNew(newProds);		        //设置是否为新产品
		product.setIsSale(saleProds);	        //设置是否特价
		product.setIsHot(hotProds);	            //设置是否为热门产品
		product.setIsSpecial(specialProds);		//设置是否为特殊产品
		product.setProductNum(Integer.parseInt(str_prodNum));	//设置商品数量
		AdminProdDao adminProdDao=new AdminProdDaoImpl();
		boolean result=adminProdDao.updateProduct(product);
		if(result){
			request.setAttribute("message", "添加成功");
		}else{
			request.setAttribute("message", "添加失败");
		}
		request.getRequestDispatcher("getProdPagerServlet").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
