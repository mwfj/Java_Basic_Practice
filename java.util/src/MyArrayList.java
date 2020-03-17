import java.util.ArrayList;
import java.util.Arrays;


public class MyArrayList {
	// 初始容量
	private static int cap = 10;
	// 递增容量
	private static int step = 10;
	// 第一个存数据的Object对象数组
	private Object objs[] = null;
	// 备份第一个数组的值
	private Object objs2[] = null;
	// 现在数据存储到了什么位置
	private int pos = 0;

	public MyArrayList() {
		this(cap, step);
	}

	public MyArrayList(int cap) {
		this(cap, step);
	}

	public MyArrayList(int cap, int step) {
		this.step = step;
		if (objs == null) {
			objs = new Object[cap];
		}

	}

	public void add(Object o) {
		if (pos == objs.length-1) {
			objs2 = new Object[objs.length];
			objs2 = Arrays.copyOf(objs, objs.length);
			
			objs = new Object[objs.length + step];
			for (int i = 0; i < objs2.length; i++) {
				objs[i] = objs2[i];
			}
			pos++;
			objs[pos]= o;
		} else {
			for (int i = 0; i < objs.length; i++) {
				if (objs[i] == null) {
					objs[i] = o;
					pos = i;
					break;
				}
			}
		}
	}

	public Object get(int pos) {
		return objs[pos];
	}

	public int size() {
		return pos +1;
		 
	}
	public static void main(String[] args) {
		
		MyArrayList list =new MyArrayList();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		list.add("f");
		list.add("g");
		list.add("h");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
