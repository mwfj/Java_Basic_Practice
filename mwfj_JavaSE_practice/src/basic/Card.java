package basic;

public class Card {

	private double balance;
	public Card(double balance) {
		// TODO Auto-generated constructor stub
		this.balance = balance;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void DespoitMoney(double despoitmoney){
		System.out.println("存入金额： "+despoitmoney);
		double temp_money = balance;
		temp_money = temp_money+despoitmoney;
		balance = temp_money;
		System.out.println("当前金额： "+balance);
	}
	public void WithdrawMoney(double withdrawmoney){
		System.out.println("取出金额: "+withdrawmoney);
		double temp_money = balance;
		temp_money = temp_money- withdrawmoney;
		balance = temp_money;
		System.out.println("当前金额： "+balance);
	}
	
}
