package mwfj.demo.entities;

import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID = -5571224028541086315L;
	
	private String  loginName;
	private String loginPassword;
	
	
	public User() {}
	
	public User(String loginName, String loginPassword) {
		this.loginName = loginName;
		this.loginPassword = loginPassword;
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
	
	

}
