import org.omg.CORBA.PUBLIC_MEMBER;


public class Person {

	public int age;
	public String name;
	public int num;
	public static void main(String[] args) {

		Person person = new Person();
		//ֵ值传递
//		int num=4;
//		person.a(num);
//		System.out.println(num);
		//引用传递
//		person.b(person);
//		System.out.println(person.num);
		//String传递
		String s = new String();
		s = "4";
		person.c(s);
		System.out.println(s);
	}
//	public  void a(int num)
//	{
//		num=5;
//
//	}
//	public void b(Person person)
//	{
//		person.num=5;
//
//	}
	public void c(String s)
	{
		s = "5";
	}
	
}
