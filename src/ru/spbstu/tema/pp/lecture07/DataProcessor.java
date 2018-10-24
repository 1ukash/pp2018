package ru.spbstu.tema.pp.lecture07;

import ru.spbstu.tema.pp.lecture07.ThreadEntry.FooContainer;

public class DataProcessor implements Runnable {

	private FooContainer data;

	public DataProcessor(FooContainer data) {
		this.data = data;
	}

	@Override
	public void run() {
		
		while(!Thread.currentThread().isInterrupted()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println("Thread was interrupted " + Thread.currentThread().isInterrupted());
				Thread.currentThread().interrupt();
			}
			System.out.println("I am in another thread! " + Thread.currentThread().getName());
			System.out.println("I have read " + data.getNum());
		}
		
	}

}
