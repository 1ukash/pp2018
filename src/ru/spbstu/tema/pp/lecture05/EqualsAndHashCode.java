package ru.spbstu.tema.pp.lecture05;

public class EqualsAndHashCode {
	
	static class Fooo {
		
		public Fooo(int x) {
			super();
			this.x = x;
		}

		int x;
		
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Fooo) {
				return ((Fooo) obj).x == x;
			}
			return false;
		}
		
		@Override
		public int hashCode() {
			return x;
		}
	}
	
	public static void main(String[] args) {
		Fooo f1 = new Fooo(1);
		Fooo f2 = new Fooo(1);
		
		String s1 = "a";
		String s2 = "a";
		
		System.out.println(f1 == f2);
		System.out.println(s1.equals(s2));
		
		System.out.println(validateHashCodeRule(f1, f2));
		System.out.println(validateHashCodeRule(s1, s2));
	}
	
	static boolean validateHashCodeRule(Object o1, Object o2){
		
		if (o1.equals(o2)) {
			return o1.hashCode() == o2.hashCode();
		}
		
		return true;
		
	}
	

}
