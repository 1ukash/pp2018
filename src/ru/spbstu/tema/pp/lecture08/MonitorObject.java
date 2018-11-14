package ru.spbstu.tema.pp.lecture08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MonitorObject {
	
	private int a;

	public synchronized int getA() {
		return a;
	}


	public synchronized void setA(int a) {
		this.a = a;
	}
	
	public  void setA1(int a) {
		synchronized (this) {
			this.a = a;
		}
	}

	
	private void foo() {
		// TODO Auto-generated method stub
		List<String> l = new ArrayList<>();
		
		List<String> l2 = Collections.synchronizedList(l);

	}
	

}
