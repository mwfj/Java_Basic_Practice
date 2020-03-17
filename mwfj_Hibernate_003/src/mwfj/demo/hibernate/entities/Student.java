package mwfj.demo.hibernate.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "test_student")
/**
 * 命名HQL的写法，相当于把HQL语句抽到一个统一的地方配置，然后取一个别名
 * 在查询的时候session.getNamedQuery(别名)
 * @author RICO
 *
 */
@NamedQueries(
			@NamedQuery(name="selectStudentAll", query="from Student s")
		)
/**
 * 类级别的检索策略，默认情况下是延迟检索，但仅对load方法有效，其他所有查询
 * get HQL QBC无效，统统是立即检索
 * @author RICO
 *
 */
@Proxy(lazy=true)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Student  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="S_STUDENT")
	@SequenceGenerator(name="S_STUDENT", sequenceName="s_tab_student", allocationSize=1)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private Integer age;
	
	public Student() {}
	
	
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}



	public Student(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	
	

}
