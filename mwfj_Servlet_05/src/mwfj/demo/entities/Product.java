package mwfj.demo.entities;

public class Product {
	
	// 主键
	private Long id;
	
	// 商品编号
	private String proNumber;
	
	// 商品名字
	private String proName;
	
	// 商品库存量
	private int proStock;
	
	public Product() {}

	public Product(Long id, String proNumber, String proName, int proStock) {
		this.id = id;
		this.proNumber = proNumber;
		this.proName = proName;
		this.proStock = proStock;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProNumber() {
		return proNumber;
	}

	public void setProNumber(String proNumber) {
		this.proNumber = proNumber;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public int getProStock() {
		return proStock;
	}

	public void setProStock(int proStock) {
		this.proStock = proStock;
	}
	
	

}
