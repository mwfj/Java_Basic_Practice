package my_collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author mwfj
 *	测试hashset集合中存放的元素不能重复
 */
public class Myset {
	public static void main(String[] args) {
		String person1 = "zhangsan";
		String person2 = "lisi";
		String person3 = "zhangsan";
		String person4 = "wangwu";
		String person5 = "maliu";
		Set<String> my_hashset = new HashSet<String>();
		my_hashset.add(person1);
		my_hashset.add(person2);
		my_hashset.add(person3);
		my_hashset.add(person4);
		my_hashset.add(person5);
		System.out.println(my_hashset.size());
		Iterator<String> iterator = my_hashset.iterator();
		while (iterator.hasNext()) {
			String string = (String) iterator.next();
			System.out.println(string);
		}

	}
	
}
