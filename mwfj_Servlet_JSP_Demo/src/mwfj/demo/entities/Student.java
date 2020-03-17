package mwfj.demo.entities;

import java.io.Serializable;

/**
 * 为了让这个类的对象可以实现序列化和反序列化
 * 
 * 序列化：将内存中的对象持久化 反序列化：将持久化对象变成内存中的对象
 * 
 * 在Java中显示创建对象的方式有4种： 1）new 2）反射机制 3）反序列化 4）克隆
 * 
 * Student student = new Student();
 * 
 * @author mwfj
 *
 */
public class Student implements Serializable {

	private static final long serialVersionUID = -9003348779719772265L;

	private String loginName;
	private String loginPassword;
	private String nickName;
	private Long id;
	private int age;

	public Student() {
	}

	public Student(String loginName, String loginPassword, String nickName) {
		this.loginName = loginName;
		this.loginPassword = loginPassword;
		this.nickName = nickName;
	}

	public Student(String nickName, Long id, int age) {
		this.nickName = nickName;
		this.id = id;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

}
