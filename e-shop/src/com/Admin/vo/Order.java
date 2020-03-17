package com.Admin.vo;

import java.sql.Date;
import java.util.List;

public class Order {
	private int orderid;
	private String username;
	private String realname;
	private String address;
	private String postcode;
	private String phone;
	private Date orderdate;
	private int flag;
	private List orderItem; //一个用于装订单项的List

	public List getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(List orderItem) {
		this.orderItem = orderItem;
	}
	
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}

	
}
