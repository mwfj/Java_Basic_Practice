package my_collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import basic.Student;

import java.util.Set;
import java.util.TreeMap;

/**
 * @author mwfj
 * HashMap的基本操作
 */
public class Mymap {
	
	public static void main(String[] args) {
			Map<String, String> myhashMap  = new HashMap<String,String>();
			myhashMap.put("key1", "zhangsan");
			myhashMap.put("key2", "lisi");
			myhashMap.put("key3", "haoyouhua");
			myhashMap.put("key4", "chenliu");
			myhashMap.put("key5", "maqi");
			//值遍历
			Collection<String> collect_value = myhashMap.values();
			for (String str : collect_value) {
				System.out.println(str);
			}
			System.out.println("------------------------------------------------------");
			//键遍历
			Collection<String> collect_key = myhashMap.keySet();
			for (String string : collect_key) {
				System.out.println(string);
			}
			System.out.println("------------------------------------------------------");
			Set<String> collect_keyset = myhashMap.keySet();
			for (String string : collect_keyset) {
				System.out.println(string);
			}
			System.out.println("------------------------------------------------------");
			//键值遍历
			Set<String> collect_keyvalue = myhashMap.keySet();
			for (String str_keyvalue : collect_keyvalue) {
				System.out.println(str_keyvalue+" "+myhashMap.get(str_keyvalue));
			}
			System.out.println("------------------------------------------------------");
			for (Entry<String, String> str_entry : myhashMap.entrySet()) {
				System.out.println(str_entry.getKey()+" "+str_entry.getValue());
			}
			System.out.println("------------------------------------------------------");
			//hashmap 存放对象
			Map< String, Student> object_hashmap = new HashMap<String,Student>();
			Student student1 = new Student();
			student1.setName("zhangsan");
			student1.setAge(25);
			Student student2 = new Student();
			student2.setName("balala");
			student2.setAge(30);
			Student student3 = new Student();
			student3.setName("wangwu");
			student3.setAge(21);
			Student student4 = new Student();
			student4.setName("haoyonghua");
			student4.setAge(30);
			object_hashmap.put("key1", student1);
			object_hashmap.put("key2", student2);
			object_hashmap.put("key3", student3);
			object_hashmap.put("key4", student4);
			//键值遍历含有对象hashmap
			for (Entry<String, Student> str_object_map : object_hashmap.entrySet()) {
				System.out.println(str_object_map.getKey()+"   "+str_object_map.getValue().getName()+":"+str_object_map.getValue().getAge());
			}
			System.out.println("------------------------------------------------------");
			System.out.println("TreeMap 可以将Map中的key值进行排序:");
			//TreeMap 可以将Map中的key值进行排序
			Map <String,String> treeMap = new TreeMap<String,String>();
			treeMap.put("key1", "zhangsan");
			treeMap.put("key2", "lisi");
			treeMap.put("key3", "haoyouhua");
			treeMap.put("key4", "chenliu");
			treeMap.put("key5", "maqi");	
			for (Entry<String, String> str_treemap : treeMap.entrySet()) {
				System.out.println(str_treemap.getKey()+"   "+str_treemap.getValue());
			}
	}
}
