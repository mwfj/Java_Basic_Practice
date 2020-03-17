package mwfj.demo.hibernate.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FishTail implements Serializable {
	private static final long serialVersionUID = -3122089270597303810L;
	
	@Column(name="tail_name")
	private String name;
	
	@Column(name="tail_length")
	private  Integer length;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}
	
	

}
