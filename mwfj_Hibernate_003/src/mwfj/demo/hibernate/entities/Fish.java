package mwfj.demo.hibernate.entities;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="s_fish")
public class Fish extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -2936448646261780691L;
	
	private String name;
	
	private String color;
	
	@Embedded
	private FishTail tail;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public FishTail getTail() {
		return tail;
	}

	public void setTail(FishTail tail) {
		this.tail = tail;
	}
	
	

}
