package ru.spbstu.tema.pp.lecture08;

import java.util.Random;

public class WaitNotify {
	static int a = new Random().nextInt(100);
	final static Object lock = new Object();
	
	public static void main(String[] args) throws InterruptedException {
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				a = a * a;
				System.out.println("calculation complete");
				synchronized (lock) {
					lock.notifyAll();
				}
			}
		}).start();

		new Thread(new Runnable() {
			
			@Override
			public void run() {
				synchronized (lock) {
					try {
						System.out.println("going to wait for signal");
						lock.wait();
						System.out.println(a);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

		Thread.sleep(5000);
	}
	

}
