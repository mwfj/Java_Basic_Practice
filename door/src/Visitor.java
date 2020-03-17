public class Visitor {
	private String pingZheng="";
	public String getPingZheng() {
		return pingZheng;
	}
	public void setPingZheng(String pingZheng) {
		this.pingZheng = pingZheng;
	}
	// 请求进入
	public void goin(Door door){
		door.setDoorBell(1);
	}
}
