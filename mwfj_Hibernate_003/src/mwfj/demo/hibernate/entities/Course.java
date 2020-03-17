package mwfj.demo.hibernate.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="s_course")
public class Course extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -8121838037799348368L;
	
	@Column
	private String name;
	
	@ManyToMany(mappedBy="courses")
	private Set<Teacher> teachers = new HashSet<Teacher>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
	
	

}
