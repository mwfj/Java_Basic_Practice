package com.Admin.dao;

import java.util.List;
import java.util.Map;

import com.Admin.vo.MerchantPager;
import com.Admin.vo.UserPager;

public interface AdminUserDao {

	public Map getAllUsers();   //显示用户
	public boolean deleteUserById(int id);   //删除用户
	public boolean deleteUsers(int[] ids);
	public boolean deleteMerchants(int[] ids);
	public UserPager getUserPager(int index, int pageSize);
	public MerchantPager getMerchentPager(int index, int pageSize);
}
