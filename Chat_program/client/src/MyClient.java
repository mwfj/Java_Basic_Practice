import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import com.sun.org.apache.xalan.internal.xsltc.trax.OutputSettings;


public class MyClient {
	public static void main(String[] args) {
		try {
			Socket socket =new Socket("127.0.0.1",9001);
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos =new DataOutputStream(os);
			DataInputStream dis =new DataInputStream(socket.getInputStream());
			dos.writeUTF("服务器你好");
			
			String content = dis.readUTF();
			System.out.println("服务器说："+content);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
