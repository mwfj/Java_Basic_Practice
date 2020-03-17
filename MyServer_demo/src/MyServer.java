import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class MyServer {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket =new ServerSocket(9001);
			System.out.println("begin");
			Socket socket = serverSocket.accept();
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			InputStream is= socket.getInputStream();
			DataInputStream dis =new DataInputStream(is);
			String content = dis.readUTF();
			System.out.println("客户端说："+content);
			dos.writeUTF("客户端你好");
			System.out.println("end");
		} catch (Exception e) {
			
		}
		
	}
}
