package mwfj.demo.hibernate.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name="s_account")
public class Account extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 5230038553785818879L;
	
	private String name;
	
	private BigDecimal balance;
	
	/*@Version
	private Integer version;*/
	
	@Version
	@Temporal(TemporalType.TIMESTAMP)
	private Date version;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Date getVersion() {
		return version;
	}

	public void setVersion(Date version) {
		this.version = version;
	}

	/*public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}*/
	
	
	
	
	

}
