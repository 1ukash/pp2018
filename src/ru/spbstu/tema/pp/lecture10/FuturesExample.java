package ru.spbstu.tema.pp.lecture10;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FuturesExample {

	static ExecutorService threadPool = Executors.newFixedThreadPool(10);

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		System.out.println("start");
		
		final int val = 10;
		Future<Integer> f = threadPool.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				int result = val * 2;
				Thread.sleep(1000);
				return result;
			}
		});
		
		while(!f.isDone()) {
			
			System.out.println("I am still waiting for computation");
			Thread.sleep(200);
			
		}
		
		System.out.println("The result is " + f.get());

		threadPool.shutdown();

	}

}
