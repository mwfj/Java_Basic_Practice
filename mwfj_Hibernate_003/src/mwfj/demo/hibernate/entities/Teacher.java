package mwfj.demo.hibernate.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/*****
 * student id name set<Course> courses
 * 
 * student_course （中间表有，但没有中间实体） fk_s_id fk_c_id
 * 
 * 
 * course id name set<Student> students
 * 
 * ---------------------------------------------- ManyToMany
 * 
 * student id name set<Course> courses
 * 
 * student_course fk_s_id fk_c_id score （中间表有，中间实体有）
 * 
 * 
 * course id name set<Student> students
 * 
 * ---------------------------------------------- 两个OneToMany
 * 
 * --------------------------------------------- product id name 1 手机 2 玩具 3 家电
 * 
 * orderitem o_id p_id price 0001 1 0001 2
 * 
 * 
 * order id number 1 0001 2 0002 3 0003
 * 
 * 
 * 
 * @author RICO
 *
 */
@Entity
@Table(name = "s_teacher")
public class Teacher extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1361765397125534888L;

	@Column
	private String name;

	@ManyToMany
	@JoinTable(name = "s_teacher_course", joinColumns = @JoinColumn(name = "t_id"), inverseJoinColumns = @JoinColumn(name = "c_id"))
	private Set<Course> courses = new HashSet<Course>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

}
