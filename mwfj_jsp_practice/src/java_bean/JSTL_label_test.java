package java_bean;

import java.io.Serializable;



public class JSTL_label_test implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8134929305730520795L;
	private String name;
	private int age;
	private boolean recommand;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isRecommand() {
		return recommand;
	}
	public void setRecommand(boolean recommand) {
		this.recommand = recommand;
	}
	

}
