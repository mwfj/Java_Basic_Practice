
public class Main {
	public static void main(String[] args) {
		// 接收所有客户端tcp请求 端口9000
		new TcpThread().start();
		// 接收所有客户端udp请求 端口9002
		new UdpThread().start();
	}
}
