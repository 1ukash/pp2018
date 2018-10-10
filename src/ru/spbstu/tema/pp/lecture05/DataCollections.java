package ru.spbstu.tema.pp.lecture05;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class DataCollections {
	
	static class Bar implements Comparable<Bar> {

		@Override
		public int compareTo(Bar o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
	
	static class Baz {
		
	}
	public static void main(String[] args) {
		
		List<String> l = new LinkedList<>();
		l.add("1");
		l.add("xcvxc");
		l.add("5");
		
		for (String s: l) {
			System.out.println(s);
		}
		
		System.out.println(l);
		
		TreeMap<Object, String> m = new TreeMap<>(new Comparator<Object>() {

			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		});
		
//		m.put("1", "2");
		m.put(new Bar(), "3");
		m.put(new Baz(), "3");
		
	}
}
