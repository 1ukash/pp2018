package ru.spbstu.tema.pp.lecture11;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CC {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// simpleUseLikeFuture();
		// withHandler();
		withHandlerApply();
	}

	private static void withHandler() throws InterruptedException, ExecutionException {
		System.out.println(Thread.currentThread().getName());

		CompletableFuture<String> f = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName());
			return "hello ";
		});

		f.thenAccept(result -> System.out.println(result + " world: " + Thread.currentThread().getName()));

		f.get();
	}

	private static void withHandlerApply() throws InterruptedException, ExecutionException {
		System.out.println(Thread.currentThread().getName());

		CompletableFuture<String> f = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName());
			return "hello ";
		});

		f.thenApply(result -> {
			String r = result + " world: " + Thread.currentThread().getName();
			System.out.println(r);
			return r;
		});

		f.thenApply(result -> {
			String r = result + " another world: " + Thread.currentThread().getName();
			System.out.println(r);
			return r;
		});

		f.get();
	}

	private static void simpleUseLikeFuture() throws InterruptedException, ExecutionException {
		System.out.println(Thread.currentThread().getName());
		CompletableFuture<String> f = CompletableFuture
				.supplyAsync(() -> "Hello world: " + Thread.currentThread().getName());

		CompletableFuture<Void> f2 = CompletableFuture
				.runAsync(() -> System.out.println("Run async hello world: " + Thread.currentThread().getName()));

		f2.get();
		String result = f.get();
		System.out.println(result);
	}
}
