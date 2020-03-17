package mwfj.demo.entities;

public class Type {
	
	private Long id;
	private String name;
	private String des;
	
	public Type(){}
	
	public Type(Long id, String name, String des) {
		this.id = id;
		this.name = name;
		this.des = des;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
