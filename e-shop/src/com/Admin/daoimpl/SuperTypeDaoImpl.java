package com.Admin.daoimpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.common.DbUtil;
import com.Admin.dao.SuperTypeDao;
import com.Admin.vo.SuperType;
import com.Admin.vo.SuperTypePager;
import com.Admin.vo.User;
import com.Admin.vo.UserPager;

public class SuperTypeDaoImpl implements SuperTypeDao {

	public List showAllSuperType() {
		List superList = new ArrayList();
		PreparedStatement pstmt = null;	
		ResultSet rs = null;
		DbUtil dbUtil = null;
		try {
			dbUtil = new DbUtil();
			String sql = "select * from t_supertype";
			pstmt = dbUtil.getCon().prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				SuperType st = new SuperType();
				st.setSuperTypeId(rs.getInt(1));
				st.setTypeName(rs.getString(2));
				superList.add(st);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pstmt.close();
				dbUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return superList;
	}
	
	public boolean addSuperType(SuperType type) {
		DbUtil dao = null;
		PreparedStatement ps = null;
		String sql = "";
		boolean flag = false;
		try {
			dao = new DbUtil();		//完成驱动加载
			sql = "insert into t_supertype values(seq_supertype.nextval,?)";
			ps = dao.getCon().prepareStatement(sql);	//获取数据库连接并执行SQL
			ps.setString(1, type.getTypeName());	//设置SQL语句
			int i = ps.executeUpdate();				//执行添加
			if(i != 0) {
				flag = true;		//返回true，表示添加成功
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				dao.close();
			} catch(SQLException s) {
				s.printStackTrace();
			}
		}
		return flag;
	}

	public List getSuperType() {
		List superTypes = new ArrayList();
		DbUtil dao = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "";
		try {
			dao = new DbUtil();
			sql = "select * from t_supertype";
			ps = dao.getCon().prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				SuperType superType = new SuperType();
				superType.setSuperTypeId(rs.getInt("superTypeId"));
				superType.setTypeName(rs.getString("typeName"));
				superTypes.add(superType);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				dao.close();
			} catch(SQLException s) {
				s.printStackTrace();
			}
		}
		return superTypes;
	}

	public boolean checkSuperTypeIsExist(String superTypeName) {
		DbUtil daoUtil = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		try {
			daoUtil = new DbUtil();
			sql = "select * from t_superType where typeName = ?";
			ps = daoUtil.getCon().prepareStatement(sql);
			ps.setString(1, superTypeName);
			rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				daoUtil.close();
			} catch(SQLException s) {
				s.printStackTrace();
			}
		}
		return false;
	}
	
	public Map getAllSuperTypes() {
		Map superTypeMap = new HashMap();
		DbUtil dao = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from t_supertype";
		try {
			dao = new DbUtil();
			ps = dao.getCon().prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				SuperType superType = new SuperType();
				superType.setSuperTypeId(rs.getInt("supertypeid"));
				superType.setTypeName(rs.getString("typename"));
				superTypeMap.put(superType.getSuperTypeId(), superType);
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
		return superTypeMap;
	}
	
	public SuperTypePager getAllSuperTypes(int index, int pageSize) {
		Map superTypeMap = new HashMap();
		DbUtil db = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			db = new DbUtil();
			String sql = "SELECT * FROM (SELECT A.*, ROWNUM RN FROM " +
						"(SELECT * FROM t_supertype) A WHERE ROWNUM <= ?) WHERE RN >= ?";
			ps = db.getCon().prepareStatement(sql);
			ps.setInt(1, index+5);
			ps.setInt(2, index+1);
			rs = ps.executeQuery();
			while(rs.next()) {
				SuperType superType = new SuperType();
				superType.setSuperTypeId(rs.getInt("supertypeid"));
				superType.setTypeName(rs.getString("typename"));
				superTypeMap.put(superType.getSuperTypeId(), superType);
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
		SuperTypePager sp = new SuperTypePager();
		sp.setSuperTypeMap(superTypeMap);
		sp.setPageSize(pageSize);
		sp.setTotalNum(getAllSuperTypes().size());
		return sp;
	}
	
	public boolean updateTypeName(int id,String typeName){
		DbUtil dao = null;
		PreparedStatement ps = null;
		String sql = "";
		boolean flag = false;
		try {
			dao = new DbUtil();		//完成驱动加载
			sql = "update t_supertype set typename=? where supertypeid=?";
			ps = dao.getCon().prepareStatement(sql);	//获取数据库连接并执行SQL
			ps.setString(1, typeName);	
			ps.setInt(2, id);
			int i = ps.executeUpdate();				//执行更新
			if(i != 0) {
				flag = true;		//返回true，表示添加成功
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				dao.close();
			} catch(SQLException s) {
				s.printStackTrace();
			}
		}
		return flag;
	}
	
	public boolean deleteSuperType(int[] ids){
		DbUtil daoUtil = null;
		PreparedStatement ps = null;
		Connection conn = null;
		String sql = "delete from t_supertype where supertypeid=?";
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
}
