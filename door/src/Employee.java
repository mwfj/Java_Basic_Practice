
public class Employee extends Visitor {
	// 刷卡进入
	public static void cardGoin(Door door){
		door.setDoorBell(1);
	}
	// 指纹识别进入
	public void zhiwenGoin(Door door){
		door.setDoorBell(1);
		
	}
}
