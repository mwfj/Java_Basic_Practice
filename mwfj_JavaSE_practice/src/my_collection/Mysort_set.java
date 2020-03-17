package my_collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import basic.Student;

public class Mysort_set {
	
	public static void main(String[] args) {
		String string1 = "ccc";
		String string2 = "zzz";
		String string3 = "aaa";
		SortedSet<String> mySortedSet = new TreeSet<String>();
		mySortedSet.add(string1);
		mySortedSet.add(string2);
		mySortedSet.add(string3);
		Iterator<String> iterator = mySortedSet.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		//使用Treeset存储自定义对象时，需要重写Sortset中的Comparator方法
		Student student1 = new Student();
		student1.setName("zhangsan");
		student1.setAge(25);
		Student student2 = new Student();
		student2.setName("balala");
		student2.setAge(30);
		Student student3 = new Student();
		student3.setName("wangwu");
		student3.setAge(21);
		SortedSet<Student>  myobjectSortset = new TreeSet<Student>(new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());
			}
		});
		myobjectSortset.add(student1);
		myobjectSortset.add(student2);
		myobjectSortset.add(student3);
		for (Student student : myobjectSortset) {
			System.out.println(student.getName()+"  "+student.getAge());
		}
	}

}
