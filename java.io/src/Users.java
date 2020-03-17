import java.io.Serializable;

//如果一个类要序列化到磁盘 这个类必须实现Serializable接口
public class Users implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6313764292464081505L;
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
