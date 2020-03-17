package thread_practice;

public class ThreadSynchroized1 extends Thread{
	private Card_synchroized card_synchroized;
	public ThreadSynchroized1(Card_synchroized card) {
		// TODO Auto-generated constructor stub
		this.card_synchroized = card;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			card_synchroized.DespoitMoney_Synchriozed(100.00);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("存钱线程结束");
	}
}
