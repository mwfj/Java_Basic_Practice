package thread_practice;

import basic.Card;

public class ThreadNormal2 extends Thread{

	private Card card;
	private Thread despoitMoney;

	public ThreadNormal2(Card card) {
		// TODO Auto-generated constructor stub
		this.card = card;
	}

	public Thread getDespoitMoney() {
		return despoitMoney;
	}

	public void setDespoitMoney(Thread despoitMoney) {
		this.despoitMoney = despoitMoney;
	}

	@Override
	public void run() {
		super.run();
		// TODO Auto-generated method stub
		try {
			Thread.sleep(10);
			System.out.println("取钱线程等待存钱线程");
			this.despoitMoney.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("开始取钱");
		card.WithdrawMoney(50.00);
		

	}
}
