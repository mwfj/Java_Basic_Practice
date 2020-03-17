package mwfj.demo.servlet;

import java.io.Serializable;

/**
 * Java中显示创建对象的方式有几种
 * 1 new
 * 2 反射
 * 3 反序列化
 * 4 克隆 
 * @author mwfj
 *
 */
public class User  implements Serializable {

	private static final long serialVersionUID = -5852577392510651124L;
	
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
	
	

}
