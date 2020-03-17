package com.Admin.dao;

import java.util.List;

import com.Admin.vo.Order;
import com.Admin.vo.OrderFreezePager;
import com.Admin.vo.OrderNotSendPager;
import com.Admin.vo.OrderPager;
import com.Admin.vo.OrderSendPager;

public interface AdminOrderDao {

	public List getAllOrder();
	public Order getOneOrder(int id);
	public List getNotSendOrder(int flag);
	public List getSendOrder(int flag);
	public boolean SendOrder(int[] orderids);
	public OrderPager getOrderPager(int index, int pageSize);
	public OrderSendPager getOrderSendPager(int index,int pageSize);
	public boolean deleteOrder(int[] ids);
	public OrderNotSendPager getOrderNotSendPager(int index,int pageSize);
	public OrderFreezePager getOrderFreezePager(int index,int pageSize);
	public boolean freezeOrder(int[] orderids);
}
