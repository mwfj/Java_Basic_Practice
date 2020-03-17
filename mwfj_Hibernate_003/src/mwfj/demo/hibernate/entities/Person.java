package mwfj.demo.hibernate.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Blob;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "s_person")
public class Person extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1664895933813488616L;

	// 字符串
//	@Column(unique = true, nullable = false, columnDefinition="NVARCHAR2(200)")
	@Column(unique = true, nullable = false)
	private String name;
	// 整数类型 (数据库中默认值是0，如果你想NULL表示，那么这个要声明成包装类型Interger)
	@Column(columnDefinition="int CHECK(age >= 1 AND age <= 200)")

	private int age = 1;
	// 浮点型
	@Column
	private float Height;
	// 双精度
	@Column
	private double Weight;
	// 日期
	@Column
	@Temporal(TemporalType.DATE)
	private Calendar birthday;
	// 日期时间
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDatetime;
	// 字符大文本
	@Column
	@Lob
	private String description;
	// 字节大文本
	@Column
	@Lob
	private Blob avatar;
	// Money
	@Column(precision=12, scale=2)
	private BigDecimal deposit;
	// Boolean
	@Column
	private boolean isMarried;

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

	public float getHeight() {
		return Height;
	}

	public void setHeight(float height) {
		Height = height;
	}

	public double getWeight() {
		return Weight;
	}

	public void setWeight(double weight) {
		Weight = weight;
	}

	public Calendar getBirthday() {
		return birthday;
	}

	public void setBirthday(Calendar birthday) {
		this.birthday = birthday;
	}

	public Date getCreatedDatetime() {
		return createdDatetime;
	}

	public void setCreatedDatetime(Date createdDatetime) {
		this.createdDatetime = createdDatetime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Blob getAvatar() {
		return avatar;
	}

	public void setAvatar(Blob avatar) {
		this.avatar = avatar;
	}

	public BigDecimal getDeposit() {
		return deposit;
	}

	public void setDeposit(BigDecimal deposit) {
		this.deposit = deposit;
	}

	public boolean isMarried() {
		return isMarried;
	}

	public void setMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}
}
