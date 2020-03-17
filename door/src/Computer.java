public class Computer {

	// ����
	public void control(Visitor visitor) {
		if (visitor.getPingZheng().equals("请求进入")) {
			System.out.println("门开了");
		}
		if (visitor.getPingZheng().equals("密码进入")) {
			System.out.println("密码验证....通过 ");
		}
		if (visitor.getPingZheng().equals("ָ指纹进入")) {
			System.out.println("指纹识别.....通过");
		}
	}

	
}
