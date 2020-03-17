package mwfj.demo.hibernate.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="s_animal")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
/**
 * name : 改变”类型列“的名字
 * disrciminatorType ：改变“类型列”的类别
 * @author mwfj
 *
 */
@DiscriminatorColumn(name="SDTYPE", discriminatorType=DiscriminatorType.INTEGER)
public class Animal extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -7014151650149510173L;
	
	private String name;
    private Float weight;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getWeight() {
		return weight;
	}
	public void setWeight(Float weight) {
		this.weight = weight;
	}

    
    


}
