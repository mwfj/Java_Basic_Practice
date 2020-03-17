package com.Admin.dao;

import java.util.List;

import com.Admin.vo.SuperType;
import com.Admin.vo.SuperTypePager;

public interface SuperTypeDao {
	//获取所有大类
	public List showAllSuperType();
	public boolean addSuperType(SuperType type);
	public List getSuperType();
	public boolean checkSuperTypeIsExist(String superTypeName);
	public SuperTypePager getAllSuperTypes(int index, int pageSize);
	public boolean updateTypeName(int id,String typeName);
	public boolean deleteSuperType(int[] ids);
}
