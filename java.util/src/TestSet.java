import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class TestSet {
	public static void main(String[] args) {
		Set<String> set  = new HashSet();
		set.add("1");
		set.size();
		for (Object object : set) {
			
		}
		
		Iterator i = set.iterator();
		while(i.hasNext()){
			String s =""+ i.next();
			System.out.println(s);
		}
	}
}
