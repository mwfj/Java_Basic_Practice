import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetSocketAddress;


public class MyUDPClient {
	public static void main(String[] args) {
		  try {
			DatagramSocket datagramSocket =new DatagramSocket();
			byte b []= "Hello UDP Server".getBytes();
			DatagramPacket p =new DatagramPacket(b,0,b.length, new InetSocketAddress("127.0.0.1",9002));
			datagramSocket.send(p);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
