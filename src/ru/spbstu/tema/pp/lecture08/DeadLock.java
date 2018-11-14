package ru.spbstu.tema.pp.lecture08;

import java.util.Random;

public class DeadLock {
	
	static Object lock1 = new Object();
	static Object lock2 = new Object();
	static Random generator = new Random();
	
	public static void main(String[] args) throws InterruptedException {
		
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				while(!Thread.currentThread().isInterrupted()) {
					boolean r = generator.nextBoolean();
//					Object l1 = r ? lock1 : lock2;
//					Object l2 = !r ? lock1 : lock2;
					Object l1 = lock1;
					Object l2 = lock2;
					
					synchronized (l1) {
						System.out.println(Thread.currentThread().getName() + " entered first critical section");
						synchronized (l2) {
							System.out.println(Thread.currentThread().getName() + " entered second critical section");
						}
					}
				}
				
			}
		};
		
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
	}

}
