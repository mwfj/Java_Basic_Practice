package com.Admin.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.Admin.dao.AdminNoticeDao;
import com.common.DbUtil;
import com.Admin.vo.AD;
import com.Admin.vo.ADPager;
import com.Admin.vo.NoticePager;
import com.Admin.vo.Notice;

public class AdminNoticeDaoImpl implements AdminNoticeDao {

	public boolean addNotice(Notice notice) {
		DbUtil dao = null;
		PreparedStatement ps = null;
		String sql = "";
		try {
			dao = new DbUtil();
			sql = "insert into t_notice(noticeid,noticetitle,noticecontent) " +
							"values(seq_notice.nextval,?,?)";
			ps = dao.getCon().prepareStatement(sql);
			ps.setString(1, notice.getNoticeTitle());
			ps.setString(2, notice.getNoticeContent());
			int i = ps.executeUpdate();
			if(i != 0) {
				return true;
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
		return false;
	}

	public List getAllNotice() {
		List noticeList = new ArrayList();
		DbUtil dao = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			dao = new DbUtil();
			String sql = "select * from t_notice";
			ps = dao.getCon().prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Notice notice = new Notice();
				notice.setNoticeId(rs.getInt("noticeid"));
				notice.setNoticeTitle(rs.getString("noticetitle"));
				notice.setNoticeContent(rs.getString("noticecontent"));
				notice.setNoticeTime(rs.getDate("noticetime"));
				noticeList.add(notice);
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
		return noticeList;
	}

	public boolean deleteNotice(int[] ids) {
		DbUtil daoUtil = null;
		PreparedStatement ps = null;
		Connection conn = null;
		String sql = "delete from t_notice where noticeid=?";
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

	public Notice getOneNotice(int id) {
		Notice notice = null;
		DbUtil dao = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			dao = new DbUtil();
			String sql = "select * from t_notice where noticeid = ?";
			ps = dao.getCon().prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				notice.setNoticeId(rs.getInt("noticeid"));
				notice.setNoticeTitle(rs.getString("noticetitle"));
				notice.setNoticeContent(rs.getString("noticecontent"));
				notice.setNoticeTime(rs.getDate("noticetime"));
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
		return notice;
	}

	public NoticePager getNoticePager(int index, int pageSize) {
		Map noticeMap = new HashMap();
		DbUtil db = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			db = new DbUtil();
			String sql = "SELECT * FROM (SELECT A.*, ROWNUM RN FROM " +
						"(SELECT * FROM t_notice) A WHERE ROWNUM <= ?) WHERE RN >= ?";
			ps = db.getCon().prepareStatement(sql);
			ps.setInt(1, index+5);
			ps.setInt(2, index+1);
			rs = ps.executeQuery();
			while(rs.next()) {
				Notice notice = new Notice();
				notice.setNoticeId(rs.getInt("noticeid"));
				notice.setNoticeTitle(rs.getString("noticetitle"));
				notice.setNoticeContent(rs.getString("noticecontent"));
				notice.setNoticeTime(rs.getDate("noticetime"));
				noticeMap.put(notice.getNoticeId(), notice);
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
		NoticePager np = new NoticePager();
		np.setNoticeMap(noticeMap);
		np.setPageSize(pageSize);
		np.setTotalNum(getAllNotice().size());
		return np;
	}
	
	public boolean addAD(AD ad) {
		DbUtil dao = null;
		PreparedStatement ps = null;
		String sql = "";
		try {
			dao = new DbUtil();
			sql = "insert into t_ad(id,adtype,subtypeid,productid,description," +
					"begintime,endtime,picture) " +
							"values(seq_ad.nextval,?,?,?,?,?,?,?)";
			ps = dao.getCon().prepareStatement(sql);
			ps.setInt(1, ad.getAdtype());
			ps.setInt(2, ad.getSubtypeid());
			ps.setInt(3, ad.getProductid());
			ps.setString(4, ad.getDescription());
			ps.setDate(5, ad.getBegintime());
			ps.setDate(6, ad.getEndtime());
			ps.setString(7, ad.getPicture());
			int i = ps.executeUpdate();
			if(i != 0) {
				return true;
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
		return false;
	}
	
	public ADPager getADPager(int index, int pageSize) {
		Map adMap = new HashMap();
		DbUtil db = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			db = new DbUtil();
			String sql = "SELECT * FROM (SELECT A.*, ROWNUM RN FROM " +
						"(SELECT * FROM t_ad) A WHERE ROWNUM <= ?) WHERE RN >= ?";
			ps = db.getCon().prepareStatement(sql);
			ps.setInt(1, index+5);
			ps.setInt(2, index+1);
			rs = ps.executeQuery();
			while(rs.next()) {
				AD ad = new AD();
				ad.setId(rs.getInt("id"));
				ad.setAdtype(rs.getInt("adtype"));
				ad.setDescription(rs.getString("description"));
				ad.setBegintime(rs.getDate("begintime"));
				ad.setEndtime(rs.getDate("endtime"));
				ad.setPicture(rs.getString("picture"));
				ad.setSubtypeid(rs.getInt("subtypeid"));
				ad.setProductid(rs.getInt("productid"));
				adMap.put(ad.getId(), ad);
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
		ADPager ap = new ADPager();
		ap.setAdMap(adMap);
		ap.setPageSize(pageSize);
		ap.setTotalNum(getAllAD().size());
		return ap;
	}
	
	public List getAllAD() {
		List adList = new ArrayList();
		DbUtil dao = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			dao = new DbUtil();
			String sql = "select * from t_ad";
			ps = dao.getCon().prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				AD ad = new AD();
				ad.setId(rs.getInt("id"));
				ad.setAdtype(rs.getInt("adtype"));
				ad.setDescription(rs.getString("description"));
				ad.setBegintime(rs.getDate("begintime"));
				ad.setEndtime(rs.getDate("endtime"));
				ad.setPicture(rs.getString("picture"));
				ad.setSubtypeid(rs.getInt("subtypeid"));
				ad.setProductid(rs.getInt("productid"));
				adList.add(ad);
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
		return adList;
	}
	
	public boolean deleteAD(int[] ids) {
		DbUtil daoUtil = null;
		PreparedStatement ps = null;
		Connection conn = null;
		String sql = "delete from t_ad where id=?";
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
	
	public boolean updateAD(AD ad) {
		DbUtil daoUtil = null;
		PreparedStatement ps = null;
		Connection conn = null;
		String sql = "update t_ad set description=?,picture=?,begintime=?,endtime=?,flag=? where id=?";
		try {
			daoUtil = new DbUtil();
			conn = daoUtil.getCon();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			ps.setString(1, ad.getDescription());
			ps.setString(2, ad.getPicture());
			ps.setDate(3, ad.getBegintime());
			ps.setDate(4, ad.getEndtime());
			ps.setInt(5, ad.getFlag());
			ps.setInt(6, ad.getId());
			int i=ps.executeUpdate();
			if(i>0){
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
