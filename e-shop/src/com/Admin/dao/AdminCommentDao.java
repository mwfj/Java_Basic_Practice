package com.Admin.dao;

import java.util.List;

import com.Admin.vo.CommentPager;

public interface AdminCommentDao {

	public List getAllComments();
	public boolean deleteComment(int[] i);
	public CommentPager getCommentPager(int index, int pageSize);
}
