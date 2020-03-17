package mwfj.demo.hibernate.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="1")
public class Bird extends Animal implements Serializable{

	private static final long serialVersionUID = 8793938821219215149L;
	
	private Integer wingCount;
    private Float flySpeed;
    
	public Integer getWingCount() {
		return wingCount;
	}
	public void setWingCount(Integer wingCount) {
		this.wingCount = wingCount;
	}
	public Float getFlySpeed() {
		return flySpeed;
	}
	public void setFlySpeed(Float flySpeed) {
		this.flySpeed = flySpeed;
	}

    
	
	

}
