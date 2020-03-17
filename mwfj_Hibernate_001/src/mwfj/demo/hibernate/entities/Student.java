package mwfj.demo.hibernate.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tab_student")
public class Student implements Serializable {

	private static final long serialVersionUID = -8377288360586286969L;
	
	
	@Override
	public String toString() {
		
		return "学生ID：" + this.id + "\t" + "学生姓名：" + this.name + "\t" + "学生年龄：" + this.age;
	}

	/**
	 * long
	 * int
	 * Integer
	 * 
	 * Java   ----   OID ----- 表
	 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SQ_STUDENT")
//	@SequenceGenerator(name="SQ_STUDENT",sequenceName="sq_tab_student", allocationSize=1)
	@Column(name="s_id")
	private Long id;
	
	@Column(name="s_name", unique=true, length=50, nullable=false)
	private String name;
	
	@Column(name="s_age", length=50)
	private int age;

	public Long getId() {
		return id;
	}

	/**
	 * ID值不能改，禁止其他应用程序更改
	 * 但是Hibernate底层是通过反射来设置的，框架可以设置，你不能设置
	 * @param id
	 */
	@SuppressWarnings("unused")
	private void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
