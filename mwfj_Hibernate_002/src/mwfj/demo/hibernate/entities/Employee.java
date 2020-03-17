package mwfj.demo.hibernate.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="s_employee")
public class Employee extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1328375858637826742L;
	
	@Column
	private String name;
	
	@ManyToOne
	@JoinColumn(name="dept_id")
	private Department department;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
	
	

}
