import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;


public class SocketUtil {
	private static DatagramSocket datagramSocket;
	// tcp发送数据
	public static void sendMessage(Socket socket,String message){
		try {
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			dos.writeUTF(message);
			 
		} catch (Exception e) {
			System.out.println(e+"SocketUtil-14");
		}
	}
	// udp发送数据
	public static void sendMessage(DatagramPacket packet){
		try {
			if(datagramSocket==null){
				datagramSocket = new DatagramSocket();
			}
			datagramSocket.send(packet);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
