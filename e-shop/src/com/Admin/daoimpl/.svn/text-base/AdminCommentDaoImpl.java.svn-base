package com.Admin.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.Admin.dao.AdminCommentDao;
import com.Admin.vo.Comment;
import com.Admin.vo.CommentPager;
import com.common.DbUtil;

public class AdminCommentDaoImpl implements AdminCommentDao {

	public List getAllComments() {
		List commentList = new ArrayList();
		DbUtil dao = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from t_comment";
		try {
			dao = new DbUtil();
			ps = dao.getCon().prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Comment comment = new Comment();
				comment.setId(rs.getInt("id"));
				comment.setCtitle(rs.getString("ctitle"));
				comment.setUsername(rs.getString("username"));
				comment.setContent(rs.getString("content"));
				comment.setProductid(rs.getInt("productid"));
				comment.setCdate(rs.getDate("cdate"));
				commentList.add(comment);
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
		return commentList;
	}

	public boolean deleteComment(int[] ids) {
		DbUtil daoUtil = null;
		PreparedStatement ps = null;
		Connection conn = null;
		String sql = "delete from t_comment where id=?";
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

	public CommentPager getCommentPager(int index, int pageSize) {
		Map commentMap = new HashMap();
		DbUtil db = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			db = new DbUtil();
			String sql = "SELECT * FROM (SELECT A.*, ROWNUM RN FROM " +
						"(SELECT * FROM t_comment) A WHERE ROWNUM <= ?) WHERE RN >= ?";
			ps = db.getCon().prepareStatement(sql);
			ps.setInt(1, index+5);
			ps.setInt(2, index+1);
			rs = ps.executeQuery();
			while(rs.next()) {
				Comment comment = new Comment();
				comment.setId(rs.getInt("id"));
				comment.setCtitle(rs.getString("ctitle"));
				comment.setUsername(rs.getString("username"));
				comment.setContent(rs.getString("content"));
				comment.setProductid(rs.getInt("productid"));
				comment.setCdate(rs.getDate("cdate"));
				commentMap.put(comment.getId(), comment);
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
		CommentPager cp = new CommentPager();
		cp.setCommentMap(commentMap);
		cp.setPageSize(pageSize);
		cp.setTotalNum(getAllComments().size());
		return cp;
	}

}
