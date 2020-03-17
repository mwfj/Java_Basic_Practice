package thread_practice;

/**
 * @author mwfj
 * synchronized修饰方法，如果是实例方法，那么使用的锁对象是this；
 * 					如果是静态方法，那么使用的锁对象是当前的class对象
 */
public class Card_synchroized {
	private double balance;
	//Object lock = new Object();

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Card_synchroized(double balance) {
		// TODO Auto-generated constructor stub
		this.balance = balance;
	}
/*	public void DespoitMoney_Synchriozed(double despoitmoney) throws InterruptedException{
		System.out.println("存入的资金"+despoitmoney);
		synchronized (lock) {
			double temp_money = balance;
			temp_money = temp_money+despoitmoney;
			balance = temp_money;
			System.out.println("存入后的资金"+balance);
		}
		

	}*/
	public void DespoitMoney_Synchriozed(double despoitmoney) throws InterruptedException{
		System.out.println("存入的资金"+despoitmoney);
		synchronized (this) {
			double temp_money = balance;
			temp_money = temp_money+despoitmoney;
			balance = temp_money;
			System.out.println("存入后的资金"+balance);
		}
	}
/*	public void WithdrawMoney_Synchriozed(double withdrawmoney) throws InterruptedException{
		System.out.println("取出的资金"+withdrawmoney);
		synchronized (lock) {
			double temp_money = balance;
			temp_money = temp_money-withdrawmoney;
			balance = temp_money;
			System.out.println("取出的资金"+balance);
		}
		
	}*/
	public void WithdrawMoney_Synchriozed(double withdrawmoney) throws InterruptedException{
		System.out.println("取出的资金"+withdrawmoney);
		synchronized (this) {
			double temp_money = balance;
			temp_money = temp_money-withdrawmoney;
			balance = temp_money;
			System.out.println("取出的资金"+balance);
		}
		
	}
	
}
