package mwfj.demo.hibernate.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="s_department")
public class Department extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -7022836654342849992L;
	
	@Column
	private String name;
	
	@OneToMany(mappedBy="department", cascade=CascadeType.ALL)
	private Set<Employee> employees;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
	
	

}
