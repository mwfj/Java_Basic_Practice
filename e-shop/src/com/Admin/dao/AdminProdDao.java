package com.Admin.dao;

import java.util.List;

import com.Admin.vo.ProdPager;
import com.Admin.vo.Product;

public interface AdminProdDao {

	//public List getAllBooks();
	public int addProduct(Product product);
	public boolean checkProdNameIsExist(String bookName);
	public List getAttrBySubType(int subtypeId);
	public ProdPager searchProd(String prodName);
	public List getProdBySubTypeId(int subTypeId);
	public ProdPager getProdPager(int index,int pageSize);
	public boolean deleteProd(int[] bookIds);
	public boolean addProdAttr(List attrList);
	public boolean updateProduct(Product product);
}
