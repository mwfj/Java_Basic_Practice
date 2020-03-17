package thread_practice;

public class ThreadSynchroized2 extends Thread{
	Card_synchroized card_synchroized;
	public ThreadSynchroized2(Card_synchroized card) {
		// TODO Auto-generated constructor stub
		this.card_synchroized = card;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			card_synchroized.WithdrawMoney_Synchriozed(50.00);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("取钱线程结束");
	}
}
