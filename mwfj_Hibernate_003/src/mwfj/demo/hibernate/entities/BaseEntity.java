package mwfj.demo.hibernate.entities;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 6424812349527080752L;
	
	/**
	 * UUID(GUID) 
	 * 1) Oracle xxxxxxxxxxxx
	 * 2) MySQL xxxx-xxxx-xxxx  | xxxxxxxxxxxx
	 * strategy = "guid";
	 * strategy = "uuid";
	 * name 和 generator 配对
	 * ----------------------------------------
	 * 注解标签可以写在属性上，也可以写在getter方法上
	 */
	
	@Id
	@GenericGenerator(name="idGenerator", strategy="uuid")
	@GeneratedValue(generator="idGenerator")
	private String id;

	public String getId() {
		return id;
	}

	@SuppressWarnings("unused")
	private void setId(String id) {
		this.id = id;
	}
	
	

}
