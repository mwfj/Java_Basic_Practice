package thread_practice;

import basic.Card;

public class ThreadNormal1 extends Thread{
	private Card card;
	private Thread withdrawThread;
	public ThreadNormal1(Card card) {
		// TODO Auto-generated constructor stub
		this.card = card;
	}


	public Thread getWithdrawThread() {
		return withdrawThread;
	}


	public void setWithdrawThread(Thread withdrawThread) {
		this.withdrawThread = withdrawThread;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			Thread.sleep(10);
			System.out.println("存钱线程睡眠3s");
			this.withdrawThread.join(1000);
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("存钱线程睡眠结束");
		card.DespoitMoney(100.00);
		
	}
}
