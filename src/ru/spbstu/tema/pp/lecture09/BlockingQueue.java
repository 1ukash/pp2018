package ru.spbstu.tema.pp.lecture09;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<T> {
	
	private Lock lock = new ReentrantLock();
	private Condition c = lock.newCondition();
	private ArrayList<T> items = new ArrayList<>();
	private final int size;

	public BlockingQueue(int size) {
		this.size = size;
	}
	
	void put(T item) throws InterruptedException {
		
		try {
			lock.lock();
			
			while (items.size() >= size) {
				c.await();
			}
			
			items.add(item);
			c.signal();
		} finally {
			lock.unlock();
		}
		
	}
	
	T get() throws InterruptedException {
		try {
			lock.lock();
			while (items.isEmpty()) {
				c.await();
			}
			
			T result = items.remove(0);
			c.signal();
			return result;
		} finally {
			lock.unlock();
		}
	}
	
	

}
