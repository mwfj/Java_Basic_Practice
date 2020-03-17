package polymorphism_practice;
class Human{
	public String instanceVar = "Human 实例变量";
	public static String staticVar = "Human 静态变量";
	public void instanceMethod() {
		System.out.println("Human实例方法");
	}
	public static void staticMethod() {
		System.out.println("Human 静态方法");
	}
}
class Man extends Human{
	public String instanceVar = "Man 实例变量";
	public static String staticVar = "Man 静态变量";
	public void instanceMethod() {
		System.out.println("Man实例方法");
	}
	public static void staticMethod() {
		System.out.println("Man 静态方法");
	}
}
public class polymorphism3 {
	public static void main(String[] args) {
		Human aHuman = new Man();
		System.out.println(aHuman.instanceVar);
		System.out.println(aHuman.staticVar);
		aHuman.instanceMethod();
		aHuman.staticMethod();

	}
}
