package mwfj.demo.hibernate.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="s_user")
public class User extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 2452217486580413936L;
	
	@Column
	private String loginName;
	@Column
	private String loginPassword;
	
	/**
	 * UserBase
	 * userBase
	 * ------------------
	 * mappedBy 映射的对象名(类名的骆驼命名法)
	 * cascade=CascadeType.ALL 设置级联方式
	 * 级联删除，级联更新....
	 */
	@OneToOne(mappedBy="user", cascade=CascadeType.ALL)
	private UserDetail userDetail;
	
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
	public UserDetail getUserDetail() {
		return userDetail;
	}
	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}
	
	
	
	

}
