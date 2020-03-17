import java.io.File;


public class Test {
	public static void main(String[] args){
		File f1 =new File("test.txt");
		File f2= new File("yesyes");
		FileTest.showProperties(f1);
		FileTest.showProperties(f2);
	}

}
