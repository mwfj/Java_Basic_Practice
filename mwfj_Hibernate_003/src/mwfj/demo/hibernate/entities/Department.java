package mwfj.demo.hibernate.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name="s_department")
public class Department extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -7022836654342849992L;
	
	@Column
	private String name;
	
	/**
	 * mappedBy="department" ：在关联关系中，由外键所在对象来负责关联关系，
	 * 我(Department)不负责
	 * 
	 * d1 
	 * e1 e2
	 * 
	 * 建立关系：
	 * 1 d1.getEmployees().add(e1); d1.getEmployees().add(e2);
	 * 2 e1.setDepartment(d1); e2.setDepartment(d1); 
	 * 
	 * ----- 外键方主导关系
	 * e1.setDepartment(d1); 
	 * e2.setDepartment(d1); 
	 * 
	 * 
	 * save(d1);
	 * save(e1);
	 * save(e2);
	 */
	@OneToMany(
			mappedBy="department", 
			cascade={CascadeType.REMOVE, CascadeType.PERSIST},
			fetch=FetchType.LAZY)
/*	@Fetch(FetchMode.SELECT)
	@BatchSize(size = 10)*/
	@Fetch(FetchMode.SUBSELECT)
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
