package mwfj.demo.hibernate.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="s_category")
public class Category extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -4138702497717629506L;
	
	private String name;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="self_id")
	private Category category;
	
	@OneToMany(mappedBy="category")
	private Set<Category> categorys = new HashSet<Category>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Category> getCategorys() {
		return categorys;
	}

	public void setCategorys(Set<Category> categorys) {
		this.categorys = categorys;
	}
	
	

}
