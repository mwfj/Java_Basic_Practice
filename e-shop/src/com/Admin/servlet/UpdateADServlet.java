package com.Admin.servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Admin.dao.AdminNoticeDao;
import com.Admin.dao.AdminProdDao;
import com.Admin.daoimpl.AdminNoticeDaoImpl;
import com.Admin.daoimpl.AdminProdDaoImpl;
import com.Admin.vo.AD;
import com.Admin.vo.Product;
import com.Admin.vo.Product_Attr;
import com.common.ImgUtil;
import com.jspsmart.upload.*;

public class UpdateADServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//新建一个SmartUpload对象
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
		String id_str=req.getParameter("id");      
		int Id=0;
		if(id_str!=null){
			Id=Integer.parseInt(id_str);
		}
		String description = req.getParameter("description").trim();             //描述
		String beginTime = req.getParameter("beginTime").trim();        //起始时间
		String endTime = req.getParameter("endTime").trim();				//结束时间
		String flag_str = req.getParameter("flag").trim();	  //状态
		String pricute=req.getParameter("pricute").trim();           //图片
		int flag = 0;
		int pages = 0;
		if(flag_str != null)	
			flag = Integer.parseInt(flag_str);
		AD ad = new AD();			//创建广告对象
		ad.setId(Id);
		ad.setDescription(description);
		ad.setBegintime(Date.valueOf(beginTime));
		ad.setEndtime(Date.valueOf(endTime));
		if("".equals(myFileName)){
			ad.setPicture(pricute);
		}else{
			ad.setPicture(myFileName);
		}
		ad.setFlag(flag);
		AdminNoticeDao adminNoticeDao=new AdminNoticeDaoImpl();
		boolean result=adminNoticeDao.updateAD(ad);
		if(result){
			request.setAttribute("message", "添加成功");
		}else{
			request.setAttribute("message", "添加失败");
		}
		request.getRequestDispatcher("getADPagerServlet").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
