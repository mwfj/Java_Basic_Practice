import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

//import jdk.nashorn.internal.ir.BreakableNode;


public class TestStream {
	public static void copyFile(String from, String to){
		try {
			InputStream inputStream =new FileInputStream(from);
			File toFile =new File(to);
			if(!toFile.exists()){
				toFile.createNewFile();
			}
			OutputStream outputStream =new FileOutputStream(toFile);
			byte b []=new byte[1024];
			while(true){
				int pos = inputStream.read(b);
				if(pos==-1)break;
				outputStream.write(b);
			}
			outputStream.close();
			inputStream.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public static void testDataStream(){
		try {
			FileOutputStream fileOutputStream= new FileOutputStream("d://test.txt");
			DataOutputStream dos =new DataOutputStream(fileOutputStream);
			dos.writeUTF("大家好");
			dos.close();
			fileOutputStream.close();
			
			FileInputStream fileInputStream =new FileInputStream("d://test.txt");
			DataInputStream dataInputStream = new DataInputStream(fileInputStream);
			String str = dataInputStream.readUTF();
			System.out.println(str);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public static void testObjectStream(){
		// 序列化
		Users users =new Users();
		users.setUsername("admin");
		users.setPassword("123");
		try {
//			FileOutputStream fos =new FileOutputStream("d://users.txt");
//			ObjectOutputStream oos =new ObjectOutputStream(fos);
//			oos.writeObject(users);
//			oos.close();
//			fos.close();
			
			FileInputStream fis =new FileInputStream("d://users.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Users users2= (Users)ois.readObject();
			System.out.println(users2.getUsername());
			System.out.println(users2.getPassword());
			ois.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	public static void testRW(){
		try {
			FileReader fr =new FileReader("d://test.txt");
			char c [] =new char[1024];
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	public static void main(String[] args) {
//		try {
//			File file =new File("d:"+File.separator+"hello.txt");
//			InputStream inputStream =new FileInputStream(file);
//			int len = inputStream.available();
//			byte b[]=new byte[len];
//			inputStream.read(b);
//			System.out.println(new String(b));
//			inputStream.close();
//			
//			OutputStream outputStream = new FileOutputStream(file);
//			outputStream.write("java.io第一扎不过".getBytes());
//			outputStream.close();
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		copyFile("d://hello.txt", "f://hello.txt");
		testDataStream();
		//testObjectStream();
	}
}
