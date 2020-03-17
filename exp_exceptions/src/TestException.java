
public class TestException {

	public static void divide(int a,int b)
	{
		System.out.println("除法运算结果为"+b/a);
	}
	public static void visitArray(int [] array,int i)
	{
		System.out.println("访问"+i+"号元素"+array[i]);
	}
	public static void declareException() throws Exception{
		System.out.println("该方法声明了异常，但实际运行中没有出现异常。");
		System.out.println("因此在调用该方法过程中不会出现程序崩溃");
		System.out.println("由于声明的异常不是运行时的异常，因此需要在调用程序中：");
		System.out.println("1. 使用try....catch处理，或者");
		System.out.println("2.在调用方法中再次声明该异常");
	}
	public static void manualException(boolean exp){
		if(exp){
			throw new RuntimeException("专门抛出一个运行是异常(不检查异常)。由于是"
					+ "不受检查的，编译期间不会出错，但是若不做try...catch处理则导致运行期间崩溃");
		}
		else{
			System.out.println("我选择不抛出异常");
		}
	}
	public static void main(String [] args) throws Exception{
		TestException.divide(1, 100);
		int []array = new int[7];
		TestException.visitArray(array, 5);
		TestException.declareException();
		try{
			TestException.manualException(true);
		}
		catch(Exception x){
			System.out.println("捕捉到了异常");
		}
		finally{
			System.out.println("无论是否捕获异常，都执行该代码块");
		}
		Person p = new Person();
		p.eat();
		
		System.out.println("这里是main方法的结尾");
	}
}
