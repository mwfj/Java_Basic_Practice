package com.Admin.vo;

import java.util.Map;

public class SubTypePager {

	private Map subTypeMap;  

	private int totalNum; 

	private int pageSize; 

	private int pagecurrentPageNo;  
	
	private int pageNum;  

	private int pageOffset; 
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	public Map getSubTypeMap() {
		return subTypeMap;
	}

	public void setSubTypeMap(Map subTypeMap) {
		this.subTypeMap = subTypeMap;
	}

	public int getPagecurrentPageNo() {
		return pagecurrentPageNo;
	}

	public void setPagecurrentPageNo(int pagecurrentPageNo) {
		this.pagecurrentPageNo = pagecurrentPageNo;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageOffset() {
		return pageOffset;
	}

	public void setPageOffset(int pageOffset) {
		this.pageOffset = pageOffset;
	}
}
