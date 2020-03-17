import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class TcpThread extends Thread {
	@Override
	public void run() {
		try {
			ServerSocket serverSocket = new ServerSocket(9000);
			while (true) {
				Socket socket = serverSocket.accept();
				InputStream is = socket.getInputStream();
				DataInputStream dis = new DataInputStream(is);
				String tcpMessage = dis.readUTF();
				System.out.println(tcpMessage);
				if (tcpMessage.startsWith("@#$%$#@login")) {//表示登陆
					tcpMessage = tcpMessage.substring(12);
					String nameVal = tcpMessage.substring(0,tcpMessage.indexOf("@#$"));
					String pwdVal = tcpMessage.substring(tcpMessage.indexOf("@#$")+3);
					UsersService usersService =new UsersService();
					Users users= usersService.doLogin(nameVal,pwdVal);
					if(users!=null){
						String  clientIp = socket.getInetAddress().getHostAddress()+"";
						users.setIp(clientIp);
						DataCenter.onlineUsers.add(users);
						// json 用一个规定格式的字符串表示一个对象信息 {id:1,name:'abc',pwd:'123'}
						// gson 是google用来出来json字符串到对象之间转换的一个jar包
						// 自定义数据传输的格式name=admin,ip=1.1.1.1:name=admin,ip=1.1.1.1;
						List<Users> list = DataCenter.onlineUsers;
						String onlineUsersInfo ="";
						for (int i = 0; i < list.size(); i++) {
							Users users2 = list.get(i);
							if(i==list.size()-1){
								onlineUsersInfo+="name="+users2.getName()+",ip="+users2.getIp();
							}else{
								onlineUsersInfo+="name="+users2.getName()+",ip="+users2.getIp()+":";
							}
						}
						Socket socket2 = new Socket(users.getIp(),DataCenter.CLIENT_TCP_PORT);
						SocketUtil.sendMessage(socket2,"@#$%$#@login"+onlineUsersInfo);
					}else{
						SocketUtil.sendMessage(socket,"login_failed");
					}
					
				}
				if (tcpMessage.startsWith("@#$%$#@chat")) {//表示登陆

				}

			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
