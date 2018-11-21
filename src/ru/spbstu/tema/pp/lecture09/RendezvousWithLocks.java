package ru.spbstu.tema.pp.lecture09;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RendezvousWithLocks {

	private int params;
	private int result;
	private boolean completed = false;
	private Lock l = new ReentrantLock();
	private Condition c = l.newCondition();

	int call(int params) throws InterruptedException {
		this.params = params;

		// wait until completed
		try {
			l.lock();
			c.signal();
			c.await();
		} finally {
			l.unlock();
		}

		int r = result;
		return r;
	}

	void process(int initial) throws InterruptedException {
		System.out.println("wait for params");
		
		try {
			l.lock();
			c.signal();
			c.await();
		} finally {
			l.unlock();
		}
	

		result = initial * params;
		Thread.sleep(2000);
		System.out.println("calculation complete");
		completed = true;
		// signal
		try {
			l.lock();
			c.signal();
		} finally {
			l.unlock();
		}
	
	}

}
