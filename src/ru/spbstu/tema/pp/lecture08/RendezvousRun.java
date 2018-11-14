package ru.spbstu.tema.pp.lecture08;

import java.util.Random;

public class RendezvousRun {
	public static void main(String[] args) {

		final Random r = new Random();
		Rendezvous obj = new Rendezvous();
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					int nextInt = r.nextInt(100);
					System.out.println("Process A is sending to process B " + nextInt);
					int res = obj.call(nextInt);
					System.out.println("Process A finally got result " + res);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				int params = r.nextInt(100);
				System.out.println("Process B produced initial param " + params);
				try {
					obj.process(params);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Proccess B is completed the task");

			}
		}).start();

	}
}
