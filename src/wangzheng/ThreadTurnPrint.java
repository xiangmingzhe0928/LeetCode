package wangzheng;

/**
 *
 * 两个线程交替打印
 *
 * @author: Xiang Mingzhe
 * @version ThreadTurnPrint.java, v 0.1 2019/12/5 16:13 XiangMingZhe Exp $
 **/
public class ThreadTurnPrint {

	public static void main(String[] args) {
		Task task = new Task();

		Thread t1 = new Thread(task, "thread1");
		Thread t2 = new Thread(task, "thread2");

		t1.start();
		t2.start();
//		Thread t3 = new Thread(task, "thread3");
//		t3.start();
	}

	static class Task implements Runnable {
		int count = 0;
		@Override
		public void run() {
			while (true) {
				synchronized (this) {
					notify();
					try {
						// 手动睡眠 便于观察
						Thread.sleep(500L);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (count > 100) {
						return;
					}
					System.out.println(Thread.currentThread().getName()+">>>>"+ count++);
					try {
						wait();
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				}
			}
		}
	}
}
