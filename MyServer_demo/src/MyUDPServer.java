import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class MyUDPServer {
	public static void main(String[] args) {
		try {
			DatagramSocket datagramSocket =new DatagramSocket(9001);
			byte b []= new byte[1024];
			DatagramPacket packet = new DatagramPacket(b,0,b.length);
			datagramSocket.receive(packet);
			String string = new String(b);
			System.out.println(string);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
