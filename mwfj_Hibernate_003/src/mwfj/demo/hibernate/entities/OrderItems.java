package mwfj.demo.hibernate.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="s_orderitems")
public class OrderItems implements Serializable {

	private static final long serialVersionUID = -2419845488984157404L;

	@Column(precision=12, scale=2)
	private BigDecimal price;
	
	@Id
	@ManyToOne()
	@JoinColumn(name="o_id", referencedColumnName="o_id")
	private Order order;
	
	@Id
	@ManyToOne()
	@JoinColumn(name="p_id", referencedColumnName="p_id")
	private Product product;
	
	public OrderItems() {}

	public OrderItems(BigDecimal price, Order order, Product product) {
		this.price = price;
		this.order = order;
		this.product = product;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
