import java.text.CollationKey;
import java.text.Collator;
import java.text.spi.CollatorProvider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.sun.org.apache.xml.internal.utils.LocaleUtility;

public class TestSort {
	// 对集合元素是中文字符串的进行排序
	public static void a() {
		List list = new ArrayList();
		list.add("张三");
		list.add("李四");
		list.add("王五");

		Comparator comparator = Collator.getInstance(java.util.Locale.CHINA);
		Collections.sort(list, comparator);
		for (Object object : list) {
			System.out.println(object);
		}
	}

	// 对集合元素是一个自定义类的时候 进行排序
	public static void b() {
		List list = new ArrayList();
		Users users1 = new Users("张三",30);
		Users users2 = new Users("李四",29);
		Users users3 = new Users("王五",40);
		list.add(users1);
		list.add(users2);
		list.add(users3);
		final Collator c = Collator.getInstance(java.util.Locale.CHINA);
		Collections.sort(list,new Comparator<Users>(){
			public int compare(Users o1, Users o2) {
				CollationKey  o1Str= c.getCollationKey(o1.getName());
				CollationKey o2Str= c.getCollationKey(o2.getName());
				if(o1Str.compareTo(o2Str)==0){
					return o2.getAge()-o1.getAge();
				}else{
					return o1Str.compareTo(o2Str);
				}
			}
		});

		for (Object object : list) {
			Users users = (Users) object;
			System.out.println(users.getName()+ users.getAge());
		}
		// 把一个集合中的Student对象  先按照名字排序 再按照age进行排序
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		b();

	}
}
