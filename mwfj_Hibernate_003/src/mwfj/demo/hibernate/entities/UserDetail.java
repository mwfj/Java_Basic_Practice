package mwfj.demo.hibernate.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="s_user_detail")
public class UserDetail  implements Serializable {

	private static final long serialVersionUID = -5971958236651009030L;

	
	@Id
	@GenericGenerator(name = "myConfig", strategy = "foreign", parameters = @Parameter(name = "property", value = "user"))
	@GeneratedValue(generator = "myConfig")
	@Column(name = "user_id", unique = true, nullable = false)
	private String id;
	
	@Column
	private String address;
	
	@Column
	private String cellPhone;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private User user;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	

}
