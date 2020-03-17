package basic;

import java.io.Serializable;

/**
 * @author mwfj
 *
 */
public class Student implements Serializable{
	/**
	 * 继承Serializable接口 即可序列化该类
	 * transient 关键字标注的属性不会被序列化,静态的属性不会被序列化
	 * 如果一个对象的属性又是一个对象，则要求这个属性对象也实现了Serializable接口
	 */
	private static final long serialVersionUID = -4114248420363867875L;
	private String name;
	private int age;
	public String school_name = "UCLA";
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

}
