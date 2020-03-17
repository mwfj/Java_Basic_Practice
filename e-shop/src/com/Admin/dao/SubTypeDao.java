package com.Admin.dao;

import java.util.List;

import com.Admin.vo.Attr;
import com.Admin.vo.Brand;
import com.Admin.vo.BrandPager;
import com.Admin.vo.SubType;
import com.Admin.vo.SubTypePager;
import com.Admin.vo.SuperTypePager;
import com.Admin.vo.AttributePager;

public interface SubTypeDao {
	//根据大类的ID以获取所有小类
	public List showAllSubTypeBySuperId(int superId);
	public List getSubTypeBySuperTypeId(int superTypeId);
	public List getSubTypes();
	public boolean addSubType(SubType type);
	public boolean checkSubTypeIsExist(String subTypeName);
	public boolean addAttribute(Attr attr);
	public boolean addBrand(Brand brand);
	public List getBrandBySubTypeId(int subTypeId);
	public SubTypePager getAllSubTypes(int index, int pageSize);
	public boolean updateTypeName(int id,String typeName);
	public boolean updateBrandName(int id,String brandName);
	public boolean deleteSubType(int[] ids);
	public SubTypePager getSubTypeBySuperId(int index, int pageSize,int superTypeId);
	public BrandPager getAllBrands(int index, int pageSize);
	public boolean deleteBrand(int[] ids);
	public AttributePager getALLAttributes(int index,int pageSize);
	public AttributePager getAttributeById(int index, int pageSize,int subTypeId);
	public boolean deleteAttribute(int[] ids);
	public boolean updateAttribute(Attr attr);
}
