import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.List;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import com.sun.swing.internal.plaf.metal.resources.metal;

@SuppressWarnings("unused")
public class UdpThread extends Thread {
	@Override
	public void run() {
		try {
			DatagramSocket datagramSocket = new DatagramSocket(DataCenter.SERVER_UDP_PORT);
			byte b[]= new byte[1024];
			DatagramPacket packet = new DatagramPacket(b,0,b.length);
			datagramSocket.receive(packet);
			String udpMessage = new String(b).trim();
			System.out.println(packet.getAddress()+"对大家说："+udpMessage);
			if(udpMessage.startsWith("#chat@")){
				List<Users> list = DataCenter.onlineUsers;
				for (Users u : list) {
					System.out.println("--------------"+u.getIp());
					DatagramPacket packet2= new DatagramPacket(udpMessage.getBytes(),0,udpMessage.getBytes().length,new InetSocketAddress(u.getIp(),DataCenter.CLIENT_UDP_PORT));
					SocketUtil.sendMessage(packet2);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		 
	}
}
