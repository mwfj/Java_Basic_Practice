package com.Admin.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.common.DbUtil;
import com.Admin.dao.AdminOrderDao;
import com.Admin.vo.*;

public class AdminOrderDaoImpl implements AdminOrderDao {

	public List getAllOrder() {
		List orderList = new ArrayList();
		DbUtil dao = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			dao = new DbUtil();
			String sql = "select * from t_order";
			ps = dao.getCon().prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Order order = new Order();
				order.setOrderid(rs.getInt("orderId"));
				order.setUsername(rs.getString("username"));
				order.setRealname(rs.getString("realName"));
				order.setAddress(rs.getString("address"));
				order.setPostcode(rs.getString("postcode"));
				order.setPhone(rs.getString("phone"));
				order.setOrderdate(rs.getDate("orderDate"));
				order.setFlag(rs.getInt("flag"));
				orderList.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				dao.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return orderList;
	}

	public Order getOneOrder(int id) {
		Order order = new Order();				//创建订单对象
		List orderItemList = new ArrayList();	//创建订单中的商品集合
		DbUtil dao = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			dao = new DbUtil();		//加载驱动和建立连接
			String sql = "select * from t_orderItem where orderId = ?";
			ps = dao.getCon().prepareStatement(sql);	//ִ执行查询
			ps.setInt(1, id);		//设置订单ID
			rs = ps.executeQuery();
			while (rs.next()) {
				OrderItem orderItem = new OrderItem();	//设置订单项对象
				orderItem.setId(rs.getInt("id"));	//设置订单项ID
				orderItem.setOrderid(rs.getInt("orderid"));	//设置订单ID
				orderItem.setProductid(rs.getInt("productid"));		//设置产品ID
				orderItem.setProductname(rs.getString("productname"));	//设置产品名称
				orderItem.setPrice(rs.getFloat("price"));		//设置价格
				orderItem.setProductnum(rs.getInt("productnum"));		//设置名称
				orderItemList.add(orderItem);	//添加到集合当中
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				dao.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		order.setOrderItem(orderItemList);	//设置到订单对象中
		return order;
	}

	public List getNotSendOrder(int flag) {
		List orderList = new ArrayList();
		DbUtil dao = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			dao = new DbUtil();
			String sql = "select * from t_order where flag = ?";
			ps = dao.getCon().prepareStatement(sql);
			ps.setInt(1, flag);
			rs = ps.executeQuery();
			while(rs.next()) {
				Order order = new Order();
				order.setOrderid(rs.getInt("orderId"));
				order.setUsername(rs.getString("name"));
				order.setRealname(rs.getString("realName"));
				order.setAddress(rs.getString("address"));
				order.setPostcode(rs.getString("postcode"));
				order.setPhone(rs.getString("phone"));
				order.setOrderdate(rs.getDate("orderDate"));
				order.setFlag(rs.getInt("flag"));
				orderList.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				dao.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return orderList;
	}

	public List getSendOrder(int flag) {
		List orderList = new ArrayList();
		DbUtil dao = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			dao = new DbUtil();
			String sql = "select * from t_order where flag = ?";
			ps = dao.getCon().prepareStatement(sql);
			ps.setInt(1, flag);
			rs = ps.executeQuery();
			while(rs.next()) {
				Order order = new Order();
				order.setOrderid(rs.getInt("orderId"));
				order.setUsername(rs.getString("username"));
				order.setRealname(rs.getString("realName"));
				order.setAddress(rs.getString("address"));
				order.setPostcode(rs.getString("postcode"));
				order.setPhone(rs.getString("phone"));
				order.setOrderdate(rs.getDate("orderDate"));
				order.setFlag(rs.getInt("flag"));
				orderList.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				dao.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return orderList;
	}

	public boolean SendOrder(int[] orderids) {
		DbUtil daoUtil = null;
		PreparedStatement ps = null;
		Connection conn = null;
		String sql = "update t_order set flag=1 where orderId=?";
		try {
			daoUtil = new DbUtil();
			conn = daoUtil.getCon();		//加载驱动和建立连接
			conn.setAutoCommit(false);		//关闭自动提交
			ps = conn.prepareStatement(sql);	//ִ执行更新
			for(int j=0;j<orderids.length;j++) {
				ps.setInt(1, orderids[j]);	//设置订单ID
				ps.addBatch();				//添加
			}
			int[] k = ps.executeBatch();	//全部执行
			conn.commit();		//提交
			if(k.length == orderids.length) {	//判断是否全部执行
				return true;	//返回true，表示执行成功
			}
		} catch (Exception e) {
			try {
				conn.rollback();	//ִ执行回滚
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} finally {
			try {
				ps.close();
				daoUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public OrderPager getOrderPager(int index, int pageSize) {
		Map orderMap = new HashMap();
		DbUtil db = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			db = new DbUtil();
			String sql = "SELECT * FROM (SELECT A.*, ROWNUM RN FROM " +
						"(SELECT * FROM t_order) A WHERE ROWNUM <= ?) WHERE RN >= ?";	//查询SQL语句
			ps = db.getCon().prepareStatement(sql);		//ִ执行SQL语句
			ps.setInt(1, index+5);		//设置每页记录数
			ps.setInt(2, index+1);		//设置记录值
			rs = ps.executeQuery();
			while(rs.next()) {
				Order order = new Order();		//创建订单对象
				order.setOrderid(rs.getInt("orderId"));
				order.setUsername(rs.getString("username"));
				order.setRealname(rs.getString("realName"));
				order.setAddress(rs.getString("address"));
				order.setPostcode(rs.getString("postcode"));
				order.setPhone(rs.getString("phone"));
				order.setOrderdate(rs.getDate("orderDate"));
				order.setFlag(rs.getInt("flag"));
				orderMap.put(order.getOrderid(), order);	//添加到集合中
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				db.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		OrderPager op = new OrderPager();
		op.setOrderMap(orderMap);
		op.setPageSize(pageSize);
		op.setTotalNum(getAllOrder().size());
		return op;
	}

	public OrderSendPager getOrderSendPager(int index, int pageSize) {
		Map orderMap = new HashMap();
		DbUtil db = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			db = new DbUtil();
			String sql = "SELECT * FROM (SELECT A.*, ROWNUM RN FROM " +
						"(SELECT * FROM t_order where flag=1) A WHERE ROWNUM <= ?) WHERE RN >= ?";
			ps = db.getCon().prepareStatement(sql);
			ps.setInt(1, index+5);
			ps.setInt(2, index+1);
			rs = ps.executeQuery();
			while(rs.next()) {
				Order order = new Order();
				order.setOrderid(rs.getInt("orderId"));
				order.setUsername(rs.getString("username"));
				order.setRealname(rs.getString("realName"));
				order.setAddress(rs.getString("address"));
				order.setPostcode(rs.getString("postcode"));
				order.setPhone(rs.getString("phone"));
				order.setOrderdate(rs.getDate("orderDate"));
				order.setFlag(rs.getInt("flag"));
				orderMap.put(order.getOrderid(), order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				db.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		OrderSendPager op = new OrderSendPager();
		op.setOrderMap(orderMap);
		op.setPageSize(pageSize);
		op.setTotalNum(getSendOrder(1).size());
		return op;
	}
	public boolean deleteOrder(int[] ids) {
		
		DbUtil daoUtil = null;
		PreparedStatement ps = null;
		Connection conn = null;
		String sql = "delete from t_order where orderId=?";
		try {
			daoUtil = new DbUtil();
			conn = daoUtil.getCon();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			for(int j=0;j<ids.length;j++) {
				ps.setInt(1, ids[j]);
				ps.addBatch();
			}
			int[] k = ps.executeBatch();
			conn.commit();
			if(k.length == ids.length) {
				return true;
			}
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} finally {
			try {
				ps.close();
				daoUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public OrderNotSendPager getOrderNotSendPager(int index, int pageSize) {
		Map orderMap = new HashMap();
		DbUtil db = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			db = new DbUtil();
			String sql = "SELECT * FROM (SELECT A.*, ROWNUM RN FROM " +
						"(SELECT * FROM t_order where flag=0) A WHERE ROWNUM <= ?) WHERE RN >= ?";
			ps = db.getCon().prepareStatement(sql);
			ps.setInt(1, index+5);
			ps.setInt(2, index+1);
			rs = ps.executeQuery();
			while(rs.next()) {
				Order order = new Order();
				order.setOrderid(rs.getInt("orderId"));
				order.setUsername(rs.getString("username"));
				order.setRealname(rs.getString("realName"));
				order.setAddress(rs.getString("address"));
				order.setPostcode(rs.getString("postcode"));
				order.setPhone(rs.getString("phone"));
				order.setOrderdate(rs.getDate("orderDate"));
				order.setFlag(rs.getInt("flag"));
				orderMap.put(order.getOrderid(), order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				db.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		OrderNotSendPager op = new OrderNotSendPager();
		op.setOrderMap(orderMap);
		op.setPageSize(pageSize);
		op.setTotalNum(getSendOrder(0).size());
		return op;
	}
	
	public OrderFreezePager getOrderFreezePager(int index,int pageSize) {
		Map orderMap = new HashMap();
		DbUtil db = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			db = new DbUtil();
			String sql = "SELECT * FROM (SELECT A.*, ROWNUM RN FROM " +
						"(SELECT * FROM t_order where flag=2) A WHERE ROWNUM <= ?) WHERE RN >= ?";
			ps = db.getCon().prepareStatement(sql);
			ps.setInt(1, index+5);
			ps.setInt(2, index+1);
			rs = ps.executeQuery();
			while(rs.next()) {
				Order order = new Order();
				order.setOrderid(rs.getInt("orderId"));
				order.setUsername(rs.getString("username"));
				order.setRealname(rs.getString("realName"));
				order.setAddress(rs.getString("address"));
				order.setPostcode(rs.getString("postcode"));
				order.setPhone(rs.getString("phone"));
				order.setOrderdate(rs.getDate("orderDate"));
				order.setFlag(rs.getInt("flag"));
				orderMap.put(order.getOrderid(), order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				db.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		OrderFreezePager op = new OrderFreezePager();
		op.setOrderMap(orderMap);
		op.setPageSize(pageSize);
		op.setTotalNum(getSendOrder(2).size());
		return op;
	}

	public boolean freezeOrder(int[] orderids) {
		DbUtil daoUtil = null;
		PreparedStatement ps = null;
		Connection conn = null;
		String sql = "update t_order set flag=2 where orderId=?";
		try {
			daoUtil = new DbUtil();
			conn = daoUtil.getCon();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			for(int j=0;j<orderids.length;j++) {
				ps.setInt(1, orderids[j]);
				ps.addBatch();
				updateScore(orderids[j]);
			}
			int[] k = ps.executeBatch();
			conn.commit();
			if(k.length == orderids.length) {
				return true;
			}
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} finally {
			try {
				ps.close();
				daoUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public void updateScore(int orderid){
		DbUtil daoUtil = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		double price=0.0;
		String username="";
		int score=1000;
		try {
			daoUtil = new DbUtil();
			String sql = "select o.username,oi.price,u.score from t_order o " +
					"left join t_orderitem oi  on o.orderid=oi.orderid " +
					"left join t_user u on o.username=u.name where oi.orderid=?";
			ps = daoUtil.getCon().prepareStatement(sql);
			ps.setInt(1, orderid);
			rs = ps.executeQuery();
			if(rs.next()) {
				price=rs.getDouble("price");
				username=rs.getString("username");
				score=rs.getInt("score");
			}
		    int newscore=(int)price/10;
		    score=score+newscore;
			String updateSql="update t_user set score=? where name=?";
			ps=daoUtil.getCon().prepareStatement(updateSql);
			ps.setInt(1, score);
			ps.setString(2, username);
			rs=ps.executeQuery();
	}catch(Exception e){
			e.printStackTrace();
	} finally {
		try {
			ps.close();
			daoUtil.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	}
}
