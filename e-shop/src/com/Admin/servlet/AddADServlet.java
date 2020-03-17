package com.Admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Admin.dao.AdminNoticeDao;
import com.Admin.daoimpl.AdminNoticeDaoImpl;
import com.Admin.vo.AD;
import com.Admin.vo.Notice;
import com.common.ImgUtil;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class AddADServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
		String subTypeId_str = req.getParameter("subTypeId");		//获取大类ID
		String adType_str = req.getParameter("adType");             //广告类型
		String prod_str = req.getParameter("productId");            //产品
		String description = req.getParameter("adContent");         // 描述
		String beginTime = req.getParameter("beginTime");           //开始的时间
		String endTime = req.getParameter("endTime");               //结束的时间
		
		int adType=0;
		if(adType_str!=null){
			adType=Integer.parseInt(adType_str);
		}
		int subypeId=0;
		if(subTypeId_str!=null){
			subypeId=Integer.parseInt(subTypeId_str);
		}
		int prodId=0;
		if(prod_str!=null){
			prodId=Integer.parseInt(prod_str);
		}
		try{
			AD ad=new AD();
			ad.setAdtype(adType);
			ad.setSubtypeid(subypeId);
			if(adType==0){
				ad.setProductid(prodId);
			}
			ad.setDescription(description);
			ad.setPicture(myFileName);
			ad.setBegintime(Date.valueOf((beginTime)));
			ad.setEndtime(Date.valueOf(endTime));
			AdminNoticeDao adminNoticeDao=new AdminNoticeDaoImpl();
			if(adminNoticeDao.addAD(ad)){
				request.setAttribute("message", "添加成功");
			}else{
				request.setAttribute("message", "添加失败");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		request.getRequestDispatcher("Admin/pages/addAD.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
