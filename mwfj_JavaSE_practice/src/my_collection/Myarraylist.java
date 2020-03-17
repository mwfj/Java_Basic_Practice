package my_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Myarraylist {

	public static void main(String[] args) {
		List<String> myarraylist = new ArrayList<String>();
		myarraylist.add("zhangsan");
		myarraylist.add("lisi");
		myarraylist.add("wangwu");
		myarraylist.add("maliu");
		Collections.sort(myarraylist);
		System.out.println(myarraylist.size());
		Iterator<String> it = myarraylist.listIterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		System.out.println("----------------------------------------------");
		myarraylist.remove(2);
		//myarraylist.remove("lisi");
		for(int i =0; i<myarraylist.size();i++){
			System.out.println(myarraylist.get(i));
		}
		boolean key = myarraylist.isEmpty();
		System.out.println("Is this LIst empty:"+ key);

	}
}
