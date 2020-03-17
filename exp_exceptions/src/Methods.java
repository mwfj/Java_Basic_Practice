
public class Methods extends Exception{
	public static void methods1()throws MyExc{
		System.out.println("该方法声明了异常，但实际运行中没有出现异常。");
		System.out.println("因此在调用该方法过程中不会出现程序崩溃");
		System.out.println("由于声明的异常不是运行时的异常，因此需要在调用程序中：");
		System.out.println("1. 使用try....catch处理，或者");
		System.out.println("2.在调用方法中再次声明该异常");
	}
	public static void methods2(boolean exp) throws MyExc
	{
		if(exp)
		{
			System.out.println("人为的异常");
			throw new MyExc();
		}
		else
		{
			System.out.println("非人为异常");
		}
		
	}
	public static void main(String []args)
	{
		try {
			Methods.methods1();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try{
			Methods.methods2(true);
		}
		catch(Exception x){
			System.out.println("捕捉到了异常");
		}
		finally{
			System.out.println("无论是否捕获异常，都执行该代码块");
		}
	}

}
