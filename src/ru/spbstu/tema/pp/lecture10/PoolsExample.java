package ru.spbstu.tema.pp.lecture10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolsExample {

	static ExecutorService threadPool = Executors.newFixedThreadPool(10);

	static class Container {
		int i;

		public Container(int i) {
			super();
			this.i = i;
		}
		
	}
	static final Container c = new Container(2);

	public static void main(String[] args) throws InterruptedException {

		System.out.println("start");
		for (int i = 0; i < 100; i++) {
			threadPool.submit(new Runnable() {

				@Override
				public void run() {
					c.i = c.i * 2;
					System.out.println(Thread.currentThread().getName());
				}

			});
		}
		System.out.println(c.i);
		Thread.sleep(1000);
		System.out.println(c.i);
		
		threadPool.shutdown();

	}

}
