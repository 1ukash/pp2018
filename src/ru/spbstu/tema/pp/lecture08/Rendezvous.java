package ru.spbstu.tema.pp.lecture08;

public class Rendezvous {

	private int params;
	private int result;
	private boolean completed = false;

	int call(int params) throws InterruptedException {
		this.params = params;

		// wait until completed
		synchronized (this) {
			while (!completed) {
				notify();
				wait();
			}
		}

		int r = result;
		return r;
	}

	void process(int initial) throws InterruptedException {
		System.out.println("wait for params");
		synchronized (this) {
			notify();
			wait();
		}

		result = initial * params;
		Thread.sleep(2000);
		System.out.println("calculation complete");
		completed = true;
		// signal
		synchronized (this) {
			notify();
		}
	}

}
