package polymorphism_practice;

class Father {

	public void func1() {
		func2();
	}

	public void func2() {
		System.out.println("AAA");
	}

}

class Children extends Father {

	public void func1(int i) {
		System.out.println("BBB");
	}
	public void show() {
		System.out.println("This is the Children class");
	}
	public void func2() {
		System.out.println("CCC");
	}
}

public class Polymorphism {
	public static void main(String[] args) {
		Father child = new Children();
		child.func1();
		Children children = new Children();
		children.show();
	}
}