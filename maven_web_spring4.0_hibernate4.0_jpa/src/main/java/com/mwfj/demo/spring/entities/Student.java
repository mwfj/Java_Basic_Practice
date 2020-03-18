package com.rico.demo.spring.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "spring_student")
public class Student extends BaseEntity {

	private static final long serialVersionUID = 790441889100779064L;

	private String loginName;

	private String loginPassword;

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

	public Student(String loginName, String loginPassword) {
		this.loginName = loginName;
		this.loginPassword = loginPassword;
	}
	
	public Student() {}

}
