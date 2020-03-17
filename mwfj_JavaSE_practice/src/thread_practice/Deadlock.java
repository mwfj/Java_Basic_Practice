package thread_practice;

/**
 * @author mwfj
 * 一个死锁的例子
 *
 */
public class Deadlock {

	public static void main(String[] args) {
		Object lock1 = new Object();
		Object lock2 = new Object();
		Thread deadlock_thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized (lock1) {
					System.out.println("This is the lock1");
					synchronized (lock2) {
						System.out.println("This is the lock2");
					}
				}
			}
		});
		Thread deadlock_thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized (lock2) {
					System.out.println("This is the lock1");
					synchronized (lock1) {
						System.out.println("This is the lock2");
					}
				}
			}
		});
		deadlock_thread1.start();
		deadlock_thread2.start();
	}
	
	
	
}
