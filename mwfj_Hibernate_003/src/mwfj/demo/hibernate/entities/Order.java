package mwfj.demo.hibernate.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="s_order")
public class Order  implements Serializable {

	private static final long serialVersionUID = 669771321529898071L;
	
	@Id
	@GenericGenerator(name="idGenerator", strategy="guid")
	@GeneratedValue(generator="idGenerator")
	@Column(name="o_id")
	private String id;
	
	
	@Column(name="o_number")
	private String number;
	
	@OneToMany(mappedBy="order")
	private Set<OrderItems> orderItems = new HashSet<OrderItems>();
	
	public Order() {}
	
	public Order(String number) {
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Set<OrderItems> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}
	
	
	

}
