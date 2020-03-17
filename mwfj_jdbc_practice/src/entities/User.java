package entities;

import java.io.Serializable;

/**
 * 记录登陆用户信息
 * @author mwfj
 *
 */
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1722714754612765271L;
	private String name;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String login_name, String login_password) {
		// TODO Auto-generated constructor stub
		this.name = login_name;
		this.password = login_password;
	}
}
