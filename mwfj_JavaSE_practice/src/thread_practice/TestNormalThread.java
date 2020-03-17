package thread_practice;

import basic.Card;

public class TestNormalThread {
	public static void main(String[] args) {

		try {
			Card card = new Card(100.00);
			ThreadNormal1 despoitThread = new ThreadNormal1(card);
			ThreadNormal2 withdrawThead = new ThreadNormal2(card);
			despoitThread.setWithdrawThread(withdrawThead);
			withdrawThead.setDespoitMoney(despoitThread);
			despoitThread.start();
			withdrawThead.start();
			Thread.sleep(100);
			System.out.println("最终金额为： "+card.getBalance());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
