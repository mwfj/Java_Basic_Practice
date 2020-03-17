package com.Admin.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.common.DbUtil;
import com.Admin.dao.AdminLoginDao;
import com.Admin.vo.Admin;

public class AdminLoginDaoImpl implements AdminLoginDao {

	public boolean login(Admin admin) {
		DbUtil db = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Boolean result=false;
		try {
			db = new DbUtil();
			String sql = "select * from t_admin where name=?";
			ps = db.getCon().prepareStatement(sql);
			ps.setString(1, admin.getName());
			rs = ps.executeQuery();
			if(rs.next()) {
				if(rs.getString("password").equals(admin.getPassword())) {
					result= true;
				} else {
					result= false;
				}
			} else {
				result= false;
			}
		} catch(SQLException e) {
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
		return result;
	}

	public boolean updatePassword(Admin admin) {
		DbUtil daoUtil = null;
		PreparedStatement ps = null;
		String sql = "update t_admin set password=? where name=?";
		try {
			daoUtil = new DbUtil();
			ps = daoUtil.getCon().prepareStatement(sql);
			ps.setString(1, admin.getPassword());
			ps.setString(2, admin.getName());
			int i = ps.executeUpdate();
			if(i != 0) {
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
}
