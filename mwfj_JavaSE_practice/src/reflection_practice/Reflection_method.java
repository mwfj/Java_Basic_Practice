package reflection_practice;

import java.lang.reflect.Method;

import basic.Student;

public class Reflection_method {

	public static void main(String[] args) {
		Class<Student> student_class = Student.class;
		//返回该类的所有方法
		Method student_method[] = student_class.getMethods();
		for (Method method : student_method) {
			System.out.println(method.getName());
		}
		System.out.println("---------------------------------------------");
		//返回自己定义的方法
		Method student_declaremethod[] = student_class.getDeclaredMethods();
		System.out.println("自己定义的方法");
		for (Method declaremethod : student_declaremethod) {
			System.out.println(declaremethod.getName());
		}
	
	}
}
