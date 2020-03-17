package reflection_practice;

import basic.Circle_impl;
import basic.Employee;
import basic.Student;
/**
 * @author mwfj
 *
 */
public class Reflection_class {

		public static void main(String[] args) {
			Class<Student> student_class = Student.class;
			//输出类名+包名
			String className = student_class.getName();
			System.out.println("Student 类名为："+"  "+className);
			//仅输出类名
			String simpleClassname = student_class.getSimpleName();
			System.out.println("简单类(只有类名而没有包名)名为:"+ "  "+simpleClassname);
			System.out.println("---------------------------------------------");
			//获取父类
			Class<?> employee_class = Employee.class;
			Class<?> superclass_employee = employee_class.getSuperclass();
			System.out.println("Employee类的父类是:"+"  "+superclass_employee.getName());
			System.out.println("---------------------------------------------");
			//获取接口
			Class<?> circle = Circle_impl.class;
			Class<?>[]  shape_impl = circle.getInterfaces();
			System.out.println("实现的接口是：");
			for(int i=0; i<shape_impl.length;i++){
				System.out.println(shape_impl[i].getName());
			}
			System.out.println("---------------------------------------------");			
		}
}
