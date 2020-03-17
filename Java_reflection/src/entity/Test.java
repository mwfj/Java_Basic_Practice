package entity;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
//import java.net.Inet4Address;

public class Test {
	public static void a(){
		try {
			// 加载Student到vm中
			Class class1= Class.forName("entity.Student");
			// 获取类的属性 
			Field field[] = class1.getDeclaredFields();
			for (Field field2 : field) {
				System.out.println("修饰符="+field2.getModifiers()+",数据类型="+field2.getGenericType()+",属性名="+field2.getName());
			}
			//System.out.println(Modifier.PRIVATE);
			Method method[]= class1.getDeclaredMethods();
			for (Method method2 : method) {
				System.out.println("方法名="+method2.getName()+",修饰符="+method2.getModifiers());
			}
			System.out.println(Modifier.PUBLIC);
			Constructor constructors[] =class1.getDeclaredConstructors();
			for (Constructor constructor : constructors) {
				System.out.println(constructor.getName());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public static void b(Object o) throws Exception{
		Class c = o.getClass();
		String classNameStr = c.getSimpleName();
		String sql ="insert into "+classNameStr+"(";
		Field fields[]= c.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			if(i==fields.length-1){
				sql+= fields[i].getName()+") values(";
			}else{
				sql+= fields[i].getName()+",";
			}
		}
		
		for (int i = 0; i < fields.length; i++) {
			//Method method = methods[i];
			String methodName = "get"+ fields[i].getName().substring(0,1).toUpperCase()+fields[i].getName().substring(1);
			Method method = c.getDeclaredMethod(methodName);
			String value = method.invoke(o)+"";
			System.out.println(methodName+"-----"+value);
			if(i==fields.length-1){
				sql+= "'"+value+"')";
			}else{
				sql+= "'"+value+"',";
			}
		}
		System.out.println(sql);
	}
	public static Object c(String className)throws Exception{
		Class class1 = Class.forName(className);
		return class1.newInstance();
	}
	public static void main(String[] args)throws Exception {
//		Student student =new Student();
//		student.setAge(30);
//		student.setName("张三");
////		// 加入类名等于表明  属性名等于列名
////		String sql ="insert into Student(age,name)values('"+student.getAge()+"','"+student.getName()+"')";
////		System.out.println(sql);
////		
////		String sql2 ="insert into Employee....";
////		
////		String sql3 ="insert into Users.....";
////		Users users =new Users();
////		users.setA("qwe");
////		users.setB("bnm");
////		users.setC("cvb");
////		try {
////			b(users);
////		} catch (Exception e) {
////			// TODO: handle exception
////		}
//		// 权限定路径（包名+类名）
//		Object object = c("entity.Student");
//		System.out.println(object);
		
//		Class c = Class.forName("entity.Test");
//		Method method = c.getDeclaredMethod("d", Integer.TYPE,String.class);
//		method.invoke(c.newInstance(), 3,"abc");
		
		Class c = Class.forName("entity.Student");
		Object object = c.newInstance();
		Method m =c.getDeclaredMethod("setAge",Integer.TYPE);
		m.invoke(object, 5);//执行上面的方法
		
		Method m2= c.getDeclaredMethod("getAge");
		int result = Integer.parseInt(m2.invoke(object)+"");
		System.out.println(result);
	}
	public void d(int a, String b){
		System.out.println(a+b);
	}
}
