package reflection_practice;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import basic.Student;

public class Reflection_field {

	public static void main(String[] args) {
		//Field 仅能获得public属性
		Class<Student> student_class = Student.class;
		Field[] student_field = student_class.getFields();
		Field[] student_declarefield = student_class.getDeclaredFields();
		for (Field field : student_field) {
			System.out.println("修饰名: "+field.getName()+"限定符: "+field.getModifiers()+"数据类型: "+field.getGenericType());
		}
		//GetDeclareName 可以获得自己定义的所有方法(包括private)
		for (Field declarefield : student_declarefield) {
			System.out.println("修饰名: "+declarefield.getName()+"限定符: "+declarefield.getModifiers()+"数据类型: "+declarefield.getGenericType());
		}
		System.out.println("Public: "+Modifier.PUBLIC);
		System.out.println("Private: "+Modifier.PRIVATE);
		System.out.println("Protect: "+Modifier.PROTECTED);
		//获取student类的构造函数
		Constructor[] constructor = student_class.getConstructors();
		System.out.println("该类的构造函数为：");
		for (Constructor constructor2 : constructor) {
			System.out.println(constructor2.getName());
		}
	}
}
