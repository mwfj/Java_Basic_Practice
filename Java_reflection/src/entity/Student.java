package entity;
/**
 * 需要把这个对象存储在Student表中
 * @author mwfj
 *
 */
public class Student {
	private int age;
	private String name;
	public int getAge() {
		return age;
	}
	public Student() {
	
	}
	public Student(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
