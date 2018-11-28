package ru.spbstu.tema.pp.lecture10;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class MoreExamples {
	
	AtomicInteger val = new AtomicInteger(10);
	int i;

	public static void main(String[] args) {
		
		concurrentModification();
		

	}

	private static void concurrentModification() {
		List<Integer> l = new CopyOnWriteArrayList<>();
		
		l.add(1);
		l.add(2);
		l.add(3);
		
		for (Integer i: l) {
			
			System.out.println(i);
			if (i == 2) {
				l.add(4);
			}
			
		}
		
		System.out.println("after");
		for (Integer i: l) {
			System.out.println(i);
		}
		
	}
}
