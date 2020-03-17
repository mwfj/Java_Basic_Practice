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
import com.Admin.dao.AdminUserDao;
import com.Admin.vo.Merchant;
import com.Admin.vo.MerchantPager;
import com.Admin.vo.User;
import com.Admin.vo.UserPager;

public class AdminUserDaoImpl implements AdminUserDao{

	public boolean deleteUserById(int id) {
		DbUtil daoUtil = null;
		PreparedStatement ps = null;
		String sql = "delete from t_user where id=?";
		try {
			daoUtil = new DbUtil();
			ps = daoUtil.getCon().prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if (i != 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
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

	public boolean deleteUsers(int[] ids) {
		DbUtil daoUtil = null;
		PreparedStatement ps = null;
		Connection conn = null;
		String sql = "delete from t_user where id=?";
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
	
	public boolean deleteMerchants(int[] ids) {
		DbUtil daoUtil = null;
		PreparedStatement ps = null;
		Connection conn = null;
		String sql = "delete from t_merchants where id=?";
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

	public Map getAllUsers() {
		Map userMap = new HashMap();
		DbUtil dao = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from t_user";
		try {
			dao = new DbUtil();
			ps = dao.getCon().prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setTruename(rs.getString("trueName"));
				user.setGender(rs.getInt("gender"));
				user.setBirthday(rs.getDate("birthday"));
				user.setAddress(rs.getString("address"));
				user.setPostcode(rs.getString("postcode"));
				user.setPhone(rs.getString("phone"));
				user.setMobile(rs.getString("mobile"));
				user.setScore(rs.getInt("score"));
				userMap.put(new Integer(user.getId()), user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				dao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userMap;
	}
	
	public Map getMerchants() {
		Map merchantMap = new HashMap();
		DbUtil dao = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from t_merchants";
		try {
			dao = new DbUtil();
			ps = dao.getCon().prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Merchant merchant = new Merchant();
				merchant.setId(rs.getInt("id"));
				merchant.setName(rs.getString("name"));
				merchant.setPassword(rs.getString("password"));
				merchant.setEmail(rs.getString("email"));
				merchant.setMobile(rs.getString("mobile"));
				merchantMap.put(merchant.getId(), merchant);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				dao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return merchantMap;
	}

	public UserPager getUserPager(int index, int pageSize) {
		Map userMap = new HashMap();
		DbUtil db = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			db = new DbUtil();
			String sql = "SELECT * FROM (SELECT A.*, ROWNUM RN FROM " +
						"(SELECT * FROM t_user) A WHERE ROWNUM <= ?) WHERE RN >= ?";
			ps = db.getCon().prepareStatement(sql);
			ps.setInt(1, index+5);
			ps.setInt(2, index+1);
			rs = ps.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setTruename(rs.getString("trueName"));
				user.setGender(rs.getInt("gender"));
				user.setBirthday(rs.getDate("birthday"));
				user.setAddress(rs.getString("address"));
				user.setPostcode(rs.getString("postcode"));
				user.setPhone(rs.getString("phone"));
				user.setMobile(rs.getString("mobile"));
				user.setScore(rs.getInt("score"));
				userMap.put(user.getId(), user);
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
		UserPager up = new UserPager();
		up.setUserMap(userMap);
		up.setPageSize(pageSize);
		up.setTotalNum(getAllUsers().size());
		return up;
	}
	
	public MerchantPager getMerchentPager(int index, int pageSize) {
		Map merchantMap = new HashMap();
		DbUtil db = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			db = new DbUtil();
			String sql = "SELECT * FROM (SELECT A.*, ROWNUM RN FROM " +
						"(SELECT * FROM t_merchants) A WHERE ROWNUM <= ?) WHERE RN >= ?";
			ps = db.getCon().prepareStatement(sql);
			ps.setInt(1, index+5);
			ps.setInt(2, index+1);
			rs = ps.executeQuery();
			while(rs.next()) {
				Merchant merchant = new Merchant();
				merchant.setId(rs.getInt("id"));
				merchant.setName(rs.getString("name"));
				merchant.setPassword(rs.getString("password"));
				merchant.setEmail(rs.getString("email"));
				merchant.setMobile(rs.getString("mobile"));
				merchantMap.put(merchant.getId(), merchant);
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
		MerchantPager mp = new MerchantPager();
		mp.setMerchantMap(merchantMap);
		mp.setPageSize(pageSize);
		mp.setTotalNum(getMerchants().size());
		return mp;
	}
}
