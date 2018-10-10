package ru.spbstu.tema.pp.lecture05;

public class EntryPoint {
	public static void main(String[] args) {
		InnerExamples ex = new InnerExamples();
		ex.setF1(2);
		System.out.println(ex.baz().doSmthWithF1AndReturn());
		
		MyImmutableObj o = new MyImmutableObj(1);
		foo(o);
		o = o.mutate(2);
		
		
	}

	private static void foo(MyImmutableObj o) {
		o.getState();
		o.mutate(23);
	}
}
