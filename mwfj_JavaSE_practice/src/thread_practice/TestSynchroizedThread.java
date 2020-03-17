package thread_practice;

public class TestSynchroizedThread {

	public static void main(String[] args) {
		try {
			Card_synchroized card_synchroized = new Card_synchroized(100);
			ThreadSynchroized1 despoitThread = new ThreadSynchroized1(card_synchroized);
			ThreadSynchroized2 withdrawThread = new ThreadSynchroized2(card_synchroized);
			despoitThread.start();
			withdrawThread.start();
			Thread.sleep(4000);
			System.out.println("最终金额为： "+card_synchroized.getBalance());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
