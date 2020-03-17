package java_bean;

import java.io.Serializable;

public class Test_javabean implements Serializable{

	/**
	 * @author mwfj
	 */
	private static final long serialVersionUID = 3151825682136318340L;
	
	private String name;
	private int age;
	private boolean male;
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

	public boolean getMale() {
		return male;
	}
	public void setMale(boolean male) {
		this.male = male;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
