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
@Table(name="s_product")
public class Product  implements Serializable {

	private static final long serialVersionUID = 2798173738803672918L;
	
	@Id
	@GenericGenerator(name="idGenerator", strategy="guid")
	@GeneratedValue(generator="idGenerator")
	@Column(name="p_id")
	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name="p_name")
	private String name;
	
	public Product(){}
	
	public Product(String name) {
		this.name = name;
	}

	@OneToMany(mappedBy="product")
	private Set<OrderItems> orderItems = new HashSet<OrderItems>();
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<OrderItems> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}
	
	
	
	

}
