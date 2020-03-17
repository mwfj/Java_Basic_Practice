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

public class AddProdServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 新建一个SmartUpload对象
		SmartUpload su = new SmartUpload();
		// 上传初始化
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
		String myFileName=file.getFileName(); //取得上载的文件的文件名
		saveFile+=myFileName;
		if(!"".equals(myFileName)){
			try {
					file.saveAs(saveFile);
			} catch (SmartUploadException e) {
			    e.printStackTrace();
			}
		}
		com.jspsmart.upload.Request req = su.getRequest();
	    String str_superTypeId = req.getParameter("superTypeId");	//获取大类ID
		String str_subTypeId = req.getParameter("subTypeId");		//获取小类ID
		String prodName = req.getParameter("prodName");             //产品名
		String brandId = req.getParameter("brandId");               //品牌
		String introduce = req.getParameter("introduce");        //相关介绍
		String str_price = req.getParameter("price");				//获取原有价格
		String str_nowPrice = req.getParameter("nowPrice");			//获取现有价格
		String str_prodNum = req.getParameter("prodNum");        	//获取产品的数量
		String origin=req.getParameter("origin");                   //获取来源
		String str_newProds = req.getParameter("newProds");      	//获取产品的类型
		String str_saleProds = req.getParameter("saleProds");
		String str_hotProds = req.getParameter("hotProds");
		String str_specialProds = req.getParameter("specialProds");
		String attrs=req.getParameter("attrs");
		String[] attrId=null;
		if(!"".equals(attrs)){
			attrId=attrs.split(",");
		}
		int newProds = 0;
		int saleProds = 0;
		int hotProds = 0;
		int specialProds = 0;
		int pages = 0;
		if(str_newProds != null)	//判断是否选择类型，如果选择则值为1，没选择为0
			newProds = Integer.parseInt(str_newProds);
		if(str_saleProds != null)
			saleProds = Integer.parseInt(str_saleProds);
		if(str_hotProds != null)
			hotProds = Integer.parseInt(str_hotProds);
		if(str_specialProds != null)
			specialProds = Integer.parseInt(str_specialProds);
		
		Product product = new Product();			//创建产品对象
		product.setSubTypeId(Integer.parseInt(str_subTypeId));		//设置所属小类ID
		product.setSuperTypeId(Integer.parseInt(str_superTypeId));    //设置所属ID
		product.setProductname(prodName);		//设置产品名
		product.setBrand(brandId);				//设置品牌
		product.setIntroduce(introduce);    	//设置介绍
		product.setOrigin(origin);	            //设置商品来源
		product.setNowprice(Double.parseDouble(str_nowPrice));	//设置现有价格
		product.setPrice(Double.parseDouble(str_price));	//设置原有价格
		product.setPicture(myFileName);		    //设置图片
		product.setIsNew(newProds);		        //是否为新品
		product.setIsSale(saleProds);	        //设置是否特价
		product.setIsHot(hotProds);	            //设置是否热卖
		product.setIsSpecial(specialProds);		//设置是否为特殊商品
		product.setProductNum(Integer.parseInt(str_prodNum));	//设置数量
		AdminProdDao adminProdDao=new AdminProdDaoImpl();
		int productId=adminProdDao.addProduct(product);
		if(attrId!=null){
			List attrList=new ArrayList();
			for(int i=0;i<attrId.length;i++){
				String attrValue=req.getParameter(attrId[i]);
				Product_Attr pAttr=new Product_Attr();
				pAttr.setProductId(productId);
				pAttr.setAttrId(Integer.parseInt(attrId[i]));
				pAttr.setAttrValue(attrValue);
				attrList.add(pAttr);
			}
			if(adminProdDao.addProdAttr(attrList)){
				request.setAttribute("message", "添加成功");
			}else{
				request.setAttribute("message", "添加失败");
			}
		}else{
			if(productId>0){
				request.setAttribute("message", "添加成功");
			}else{
				request.setAttribute("message", "添加失败");
			}
		}
		request.getRequestDispatcher("Admin/pages/addProduct.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
