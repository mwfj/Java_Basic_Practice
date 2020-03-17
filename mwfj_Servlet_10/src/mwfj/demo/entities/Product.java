package mwfj.demo.entities;

import java.io.Serializable;

public class Product implements Serializable {

	private static final long serialVersionUID = 9190989425986752040L;
	// 商品ID 主键（自动增长）
	private Long id;
	// 商品编号（唯一）
	private String number;
	// 商品名称
	private String name;
	// 商品描述
	private String des;
	
	
	public Product(){}
	
	public Product(Long id, String number, String name, String des) {
		this.id = id;
		this.number = number;
		this.name = name;
		this.des = des;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	
	
	
	
	
	

}
