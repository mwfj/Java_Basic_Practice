import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;


public class TestMap {
	public static void main(String[] args) {
		Map map1 = new HashMap();
		Map map2 =new Hashtable();
		// Map是线程不安全的  Hashtable是安全的  
		map1.put("a", "helloworld");
		map1.put("b", "abc");
		//map2.put(null, "a");
		System.out.println(map1.get("a"));
		
		Set set = map1.keySet();
		for (Object object : set) {
			System.out.println(object);
		}
		
		Collection c=map1.values();
		for (Object object : c) {
			System.out.println(object);
		}
	}
}
