package ru.spbstu.tema.pp.lecture07;

import java.util.LinkedList;
import java.util.List;

public class Shop {
	
	
	static final Object LOCK = new Object();
	
	static class BuyingProcess implements Runnable {
		
		private static final int PRICE = 2;
		Buyer b;
		Seller s;

		public BuyingProcess(Buyer b, Seller s) {
			this.b = b;
			this.s = s;
		}

		@Override
		public void run() {
			
			while(!Thread.currentThread().isInterrupted()) {
				
				if (b.getAccount() < PRICE) {
//					System.out.println(s.getGoodsNum());
					break;
				}
				
				synchronized (s) {
					if (s.getGoodsNum() > 0) {
						s.setGoodsNum(s.getGoodsNum() - 1);
						s.setAccount(s.getAccount() + PRICE);
						b.setAccount(b.getAccount() - PRICE);
						b.setGoodsNum(b.getGoodsNum() + 1);
					} 
				}
				
				if (s.getGoodsNum() <= 0) {
//					System.out.println(s.getGoodsNum());
					break;
				}
				
			}
			
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		List<Buyer> l = new LinkedList<>();
		l.add(new Buyer(1000000));
		l.add(new Buyer(1000000));
		l.add(new Buyer(1000000));
		Seller s = new Seller(1000000);
		
		List<Thread> threads = new LinkedList<>();
		
		for (Buyer b : l) {
			BuyingProcess p  = new BuyingProcess(b, s);
			Thread t = new Thread(p);
			t.start();
			threads.add(t);
		}
		
		for (Thread t: threads) {
			t.join();
		}
		
		System.out.println("Goods:");
		int totalGoods = 0;
		System.out.println("Seller " + s.getGoodsNum());
		totalGoods += s.getGoodsNum();
		
		for (Buyer b : l) {
			System.out.println("Buyer " + b.getGoodsNum());
			totalGoods += b.getGoodsNum();
		}
		System.out.println("Total goods " + totalGoods);
		
		
		int totalMoney = 0;
		System.out.println("Money:");
		System.out.println("Seller " + s.getAccount());
		totalMoney += s.getAccount();
		for (Buyer b : l) {
			System.out.println("Buyer " + b.getAccount());
			totalMoney += b.getAccount();
		}
		System.out.println("Total money " + totalMoney);
		
	}

}
