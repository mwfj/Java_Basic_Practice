public class Test {

	public static void main(String[] args) {
		// 刷卡 测试访客刷卡进入
//		final Door door =new Door();
//		final Employee visitor = new Employee();
//		visitor.setPingZheng("密码进入");
//		visitor.cardGoin(door);
		// 按门铃 测试房客按门铃进入	
//		final Door door =new Door();

//		final Visitor visitor = new Visitor();
//		visitor.setPingZheng("请求进入");
//		visitor.goin(door);
		//  扫描指纹 测试指纹扫描进入
		final Door door =new Door();
		final Employee visitor = new Employee();
		visitor.setPingZheng("指纹进入");
		visitor.goin(door);
		// 它是与主线程同时存在
		new Thread(){
			public void run() {
				Computer computer =new Computer();
				while(true){
					if(door.getDoorBell()==1){
						computer.control(visitor);
						break;
					}
				}
			}
		}.start();
		
	}
}
