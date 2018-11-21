package ru.spbstu.tema.pp.lecture09;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadersAndWriters {
	
	static int num = 0;
	static ReadWriteLock rwLock = new ReentrantReadWriteLock();
	
	public static void main(String[] args) {
		List<Thread> threads = new ArrayList<>();
		
		for (int i = 0; i < 2; i++) {
			threads.add(generateWriter());
		}
		for (int i = 0; i < 10; i++) {
			threads.add(generateReader());
		}
		
		for (Thread t : threads) {
			t.start();
		}
	}

	private static Thread generateReader() {
		return new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (!Thread.currentThread().isInterrupted()) {
					Lock readLock = rwLock.readLock();
					try {
						readLock.lock();
						System.out.println(Thread.currentThread().getName() + " reader read " + num);
						Thread.sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						readLock.unlock();
					}
					
		
				}
			}
		});
	}

	private static Thread generateWriter() {
		final Random r = new  Random();
		return new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (!Thread.currentThread().isInterrupted()) {
					Lock writeLock = rwLock.writeLock();
					try {
						writeLock.lock();
						num = r.nextInt(100);
						System.out.println(Thread.currentThread().getName() + " writer generated " + num);
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						writeLock.unlock();
					}
					
					System.out.println("Writer will sleep 5 sec ");
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
	}

}
