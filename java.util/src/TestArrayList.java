import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.text.StyledEditorKit.ForegroundAction;


public class TestArrayList {
	public static void a(){
//		List list = new ArrayList();
//		Users users =new Users();
//		users.setName("abc");
//		Users users2 =new Users();
//		users2.setName("abc");
//		System.out.println(users.hashCode());
//		System.out.println(users2.hashCode());
//		System.out.println(users.equals(users2));
////		list.add(users);
////		list.add(users);
////		System.out.println(list.size());
//		
//		Set set =new HashSet();
//		set.add(users);
//		set.add(users2);
//		System.out.println(set.size());
	}
	public static void b(){
		List list  =new ArrayList();
		 
		for (Object object : list) {
			
		}
		list.add("1");
		list.add("2");
		list.add("3");
		 System.out.println(list.get(2));
		for (Object object : list) {
			System.out.println(object);
		}
		
		Set set = new HashSet();
		set.add("2");
		set.add("1");
		set.add("1");
		set.add("3");
		for (Object object : set) {
			System.out.println(object);
		}
//		Iterator iterator = set.iterator();
//		while(iterator.hasNext()){
//			String s =(String) iterator.next();
//			System.out.println(s);
//		}
	}
	public static void testMyArrayList(){
		MyArrayList list = new MyArrayList();
		list.add("1");
		list.add("2");
		list.add("3");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	public static void main(String[] args) {
		testMyArrayList();
	}
}
