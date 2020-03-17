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
import com.Admin.dao.AdminProdDao;
import com.Admin.vo.*;

public class AdminProdDaoImpl implements AdminProdDao{

	
	public List getAllProds() {
		List products = new ArrayList();
		DbUtil daoUtil = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		try {
			daoUtil = new DbUtil();
			sql = "select * from t_product";
			ps = daoUtil.getCon().prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();		//创建书籍对象
				product.setProductid(rs.getInt("productid"));		//书籍ID
				product.setSuperTypeId(rs.getInt("superType"));	//所属大类ID
				product.setSubTypeId(rs.getInt("subType"));		//所属小类ID
				product.setProductname(rs.getString("productname"));		//名称
				product.setIntroduce(rs.getString("introduce"));	//介绍
				product.setPrice(rs.getFloat("price"));			//原价格
				product.setNowprice(rs.getFloat("nowPrice"));		//现价格
				product.setPicture(rs.getString("picture"));		//图片
				product.setIntime(rs.getDate("inTime"));	
				product.setIsNew(rs.getInt("isNew"));		//是否是新书
				product.setIsHot(rs.getInt("isHot"));		//是否热销
				product.setIsSale(rs.getInt("isSale"));		//是否特价
				product.setProductNum(rs.getInt("productNum"));			//商品数量
				product.setBrand(rs.getString("brand"));    //品牌
				product.setOrigin(rs.getString("origin"));  //商品来源
				products.add(product);
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
		return products;
	}

	public int addProduct(Product product) {		//添加书籍方法
		DbUtil daoUtil = null;
		PreparedStatement ps = null;
		String sql = "";
		ResultSet rs=null;
		//boolean result=false;
		int result=0;
		try {
			daoUtil = new DbUtil();		//加载驱动和建立连接
			String sqlId = "select seq_product.nextval as productid from dual";
			ps = daoUtil.getCon().prepareStatement(sqlId);
			rs = ps.executeQuery();
			int seqId=0;
			if (rs.next()) {
				seqId=rs.getInt(1);
			}
			sql = "insert into t_product (productid,supertype,subtype,productname,brand," +
					"introduce,price,nowprice,picture,origin,isnew,issale,ishot,isspecial,productnum)" +
					"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = daoUtil.getCon().prepareStatement(sql);	//执行SQL语句
			ps.setInt(1, seqId);		//设置序列ID
			ps.setInt(2, product.getSuperTypeId());		//设置大类ID
			ps.setInt(3, product.getSubTypeId());			//设置小类ID
			ps.setString(4, product.getProductname());		//设置产品名称
			ps.setString(5, product.getBrand());			//设置品牌
			ps.setString(6, product.getIntroduce());		//设置介绍
			ps.setDouble(7, product.getPrice());			//设置原价格
			ps.setDouble(8, product.getNowprice());			//设置现价格
			ps.setString(9, product.getPicture());			//设置图片
			ps.setString(10, product.getOrigin());				//设置商品来源
			ps.setInt(11, product.getIsNew());			//设置是否为新品
			ps.setInt(12, product.getIsSale());			//设置是否特价
			ps.setInt(13, product.getIsHot());			//设置是否热销
			ps.setInt(14, product.getIsSpecial());		//设置是否为特种
			ps.setInt(15, product.getProductNum());			//设置商品数量
			int i = ps.executeUpdate();		//ִ执行添加
			if(i != 0) {
				result=seqId;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				daoUtil.close();
			} catch(SQLException s) {
				s.printStackTrace();
			}
		}
		return result;
	}
	
	public boolean updateProduct(Product product) {		//添加书籍方法
		DbUtil daoUtil = null;
		PreparedStatement ps = null;
		String sql = "";
		boolean result=false;
		try {
			daoUtil = new DbUtil();		//加载驱动和建立连接
			sql = "update t_product set productname=?,introduce=?,price=?,nowprice=?," +
					"picture=?,origin=?,isnew=?,issale=?,ishot=?,productnum=?" +
					" where productid=?";
			ps = daoUtil.getCon().prepareStatement(sql);	//执行SQL语句
			ps.setString(1, product.getProductname());		//设置产品名称
			ps.setString(2, product.getIntroduce());		//设置介绍
			ps.setDouble(3, product.getPrice());			//设置原有价格
			ps.setDouble(4, product.getNowprice());			//设置现有价格
			ps.setString(5, product.getPicture());			//设置图片
			ps.setString(6, product.getOrigin());				//设置商品来源
			ps.setInt(7, product.getIsNew());			//设置是否为新品
			ps.setInt(8, product.getIsSale());			//设置是否特价
			ps.setInt(9, product.getIsHot());			//设置是否热销
			ps.setInt(10, product.getProductNum());			//设置产品数量
			ps.setInt(11, product.getProductid());	
			int i = ps.executeUpdate();		//执行添加
			if(i != 0) {
				result=true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				daoUtil.close();
			} catch(SQLException s) {
				s.printStackTrace();
			}
		}
		return result;
	}
	public boolean addProdAttr(List attrList){
		DbUtil dao = null;
		PreparedStatement ps = null;
		String sql = "";
		boolean result=false;
		try{
			dao = new DbUtil();		//加载驱动和建立连接
			sql = "insert into t_product_attr (id,productid,attrid,attrvalue)" +
					"values(seq_product_attr.nextval,?,?,?)";
			if(attrList.size()>0){
				for(int i=0;i<attrList.size();i++){
					Product_Attr pAttr=(Product_Attr)attrList.get(i);
					ps = dao.getCon().prepareStatement(sql);	//执行SQL语句
					ps.setInt(1, pAttr.getProductId());		//设置商品ID
					ps.setInt(2, pAttr.getAttrId());			//设置属性ID
					ps.setString(3, pAttr.getAttrValue());		//设置属性值
					int j = ps.executeUpdate();		//执行添加
					if(j != 0) {
						result= true;				//返回true代表添加成功
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				dao.close();
			} catch(SQLException s) {
				s.printStackTrace();
			}
		}
		return result;
	}
	public boolean checkProdNameIsExist(String productName) {
		DbUtil daoUtil = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		try {
			daoUtil = new DbUtil();
			sql = "select * from t_product where productname = ?";
			ps = daoUtil.getCon().prepareStatement(sql);
			ps.setString(1, productName);
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

	public List getAttrBySubType(int subtypeId){
		List attrLists=new ArrayList();
		PreparedStatement pstmt = null;	
		ResultSet rs = null;
		DbUtil dbUtil = null;
		try {
			dbUtil = new DbUtil();
			String sql = "select * from t_attr where subTypeId=?";
			pstmt = dbUtil.getCon().prepareStatement(sql);
			pstmt.setInt(1, subtypeId);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Attr attr = new Attr();
				attr.setAttrid(rs.getInt(1));
				attr.setAttrname(rs.getString(2));
				attr.setAttrtype(rs.getInt(3));
				attr.setAttrvalue(rs.getString(4));
				attrLists.add(attr);
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
		return attrLists;
	}

	public ProdPager searchProd(String prodName) {
		Map ProdMap = new HashMap();
		DbUtil daoUtil = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		try {
			daoUtil = new DbUtil();
			sql = "select * from t_product where productName like ?";
			ps = daoUtil.getCon().prepareStatement(sql);
			ps.setString(1, "%"+prodName+"%");
			rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();		//创建商品对象
				product.setProductid(rs.getInt("productid"));		//设置书籍ID
				product.setSuperTypeId(rs.getInt("superType"));	//设置所属大类ID
				product.setSubTypeId(rs.getInt("subType"));		//设置所属小类ID
				product.setProductname(rs.getString("productname"));		//设置商品名称
				product.setIntroduce(rs.getString("introduce"));	//设置介绍
				product.setPrice(rs.getFloat("price"));			//原价格
				product.setNowprice(rs.getFloat("nowPrice"));		//现价格
				product.setPicture(rs.getString("picture"));		//图片
				product.setIntime(rs.getDate("inTime"));	
				product.setIsNew(rs.getInt("isNew"));		//是否为新品
				product.setIsHot(rs.getInt("isHot"));		//是否热销
				product.setIsSale(rs.getInt("isSale"));		//是否特价
				product.setProductNum(rs.getInt("productNum"));	//设置商品数量
				product.setBrand(rs.getString("brand"));    //品牌
				product.setOrigin(rs.getString("origin"));  //商品来源
				ProdMap.put(product.getProductid(), product);	//添加到Map集合中
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				daoUtil.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		ProdPager prodPager = new ProdPager();
		prodPager.setProdMap(ProdMap);
		prodPager.setTotalNum(ProdMap.size());
		return prodPager;
	}
	/*
	public List getAllBookName() {
		List bookNameList = new ArrayList();
		DbUtil daoUtil = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		try {
			daoUtil = new DbUtil();
			sql = "select bookName from tb_book";
			ps = daoUtil.getCon().prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				bookNameList.add(rs.getString("bookName"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				daoUtil.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return bookNameList;
	}
	*/

	public ProdPager getProdPager(int index,int pageSize) {
		Map prodMap = new HashMap();	//创建MAP集合
		DbUtil db = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			db = new DbUtil();
			String sql = "SELECT * FROM (SELECT A.*, ROWNUM RN FROM " +
						"(SELECT * FROM t_product) A WHERE ROWNUM <= ?) WHERE RN >= ?"; 
			ps = db.getCon().prepareStatement(sql);
			ps.setInt(1, index+5);		//设置记录值
			ps.setInt(2, index+1);		//设置每页数量
			rs = ps.executeQuery();		//执行查询
			while(rs.next()) {
				Product product = new Product();		//创建产品对象
				product.setProductid(rs.getInt("productid"));		//书籍ID
				product.setSuperTypeId(rs.getInt("superType"));	//所属大类ID
				product.setSubTypeId(rs.getInt("subType"));		//所属小类ID
				product.setProductname(rs.getString("productname"));		//商品名
				product.setIntroduce(rs.getString("introduce"));	//商品介绍
				product.setPrice(rs.getFloat("price"));			//原价格
				product.setNowprice(rs.getFloat("nowPrice"));		//现价格
				product.setPicture(rs.getString("picture"));		//图片
				product.setIntime(rs.getDate("inTime"));	
				product.setIsNew(rs.getInt("isNew"));		//是否是新品
				product.setIsHot(rs.getInt("isHot"));		//是否热销
				product.setIsSale(rs.getInt("isSale"));		//是否特价
				product.setProductNum(rs.getInt("productNum"));			//数量
				product.setBrand(getBrand(rs.getString("brand")));    //品牌
				product.setOrigin(rs.getString("origin"));  //商品来源
				prodMap.put(product.getProductid(), product);	//添加到MAP集合总
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
		ProdPager bp = new ProdPager();		//创建分页产品对象
		bp.setProdMap(prodMap);				//设置Map对象
		bp.setPageSize(pageSize);			//设置每一页的记录数
		bp.setTotalNum(getAllProds().size());	//设置总记录数
		return bp;
	}
	
	public String getBrand(String brandId){
		DbUtil daoUtil = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		String brand="";
		try {
			daoUtil = new DbUtil();
			sql = "select * from t_brand where brandid ="+brandId;
			ps = daoUtil.getCon().prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				brand=rs.getString("brandname");
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				daoUtil.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return brand;
	}
	public boolean deleteProd(int[] prodIds) {
		DbUtil daoUtil = null;
		PreparedStatement ps = null;
		Connection conn = null;
		String sql = "delete from t_product where productId=?";
		try {
			daoUtil = new DbUtil();
			conn = daoUtil.getCon();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			for(int j=0;j<prodIds.length;j++) {
				ps.setInt(1, prodIds[j]);
				ps.addBatch();
				deleteAttribute(prodIds[j]);
			}
			int[] k = ps.executeBatch();
			conn.commit();
			if(k.length == prodIds.length) {
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

	//删除产品同时将该产品的所有属性一并删除
	public void deleteAttribute(int productid){
		DbUtil daoUtil = null;
		PreparedStatement ps = null;
		Connection conn = null;
		String sql = "delete from t_product_attr where productid=?";
		try {
			daoUtil = new DbUtil();
			conn = daoUtil.getCon();
			ps = conn.prepareStatement(sql);	//获取数据库连接执行SQL
			ps.setInt(1, productid);	
			ps.executeUpdate();				//ִ执行添加
		}catch (Exception e) {
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
	}
	
	public List getProdBySubTypeId(int subTypeId) {
		List products = new ArrayList();
		DbUtil dao = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = ""	;
		try {
			dao = new DbUtil();
			sql = "select * from t_product where subType = ?";
			ps = dao.getCon().prepareStatement(sql);
			ps.setInt(1, subTypeId);
			rs = ps.executeQuery();
			while(rs.next()) {
				Product product = new Product();
				product.setSubTypeId(rs.getInt("subType"));
				product.setProductid(rs.getInt("productid"));
				product.setProductname(rs.getString("productname"));
				products.add(product);
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
		return products;
	}
}
