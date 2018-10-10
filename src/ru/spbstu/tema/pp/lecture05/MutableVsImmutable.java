package ru.spbstu.tema.pp.lecture05;

public class MutableVsImmutable {
	
	public static void main(String[] args) {
		
		String s = "abcd";
		
		s = s + "ef";
		
		String s1 = "ax";
		String s2 = "ax";
		
		System.out.println(s1 == s2);
		
		Integer i1 = 2500;
		Integer i2 = 2500;
		
		System.out.println(i1 == i2);
		
		s = "";
		for (int i = 0; i < 10; i++) {
			s = s + i;
		}
		
		System.out.println(s);
		
	}

}
