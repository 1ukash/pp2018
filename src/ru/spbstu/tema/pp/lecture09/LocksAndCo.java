package ru.spbstu.tema.pp.lecture09;

import java.util.Random;

public class LocksAndCo {
	
	public static void main(String[] args) {
		
		final BlockingQueue<Integer> interchange = new BlockingQueue<>(50);
		final Random r = new  Random();
		Thread reader = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (!Thread.currentThread().isInterrupted()) {
					try {
						int num = r.nextInt(100);
						System.out.println("Writer generated " + num);
						interchange.put(num);
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		Thread writer = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (!Thread.currentThread().isInterrupted()) {
					try {
						int num = interchange.get();
						System.out.println("Reader read " + num);
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		reader.start();
		writer.start();
	}

}
