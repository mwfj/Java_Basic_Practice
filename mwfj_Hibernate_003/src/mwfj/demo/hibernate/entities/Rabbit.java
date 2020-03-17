package mwfj.demo.hibernate.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="2")
public class Rabbit extends Animal implements Serializable {


	private static final long serialVersionUID = -300423997497761471L;
	
	private Float ranSpeed;
    private Integer legCount;
    
	public Float getRanSpeed() {
		return ranSpeed;
	}
	public void setRanSpeed(Float ranSpeed) {
		this.ranSpeed = ranSpeed;
	}
	public Integer getLegCount() {
		return legCount;
	}
	public void setLegCount(Integer legCount) {
		this.legCount = legCount;
	}

    

}
