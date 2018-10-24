package ru.spbstu.tema.pp.lecture06;

public class Exceptions {
	
	
	static class Foo {
		
	}
	
	public static void main(String[] args) {
		
		Object someRef = null;
		
		try {
			nullPointerGenerator(someRef);
		} catch (NullPointerException e){
			System.err.println("Error in code " + e);
		} finally {
			System.out.println("do final operations");
		}
		
		try {
			classCastException(new Object());
		} catch (RuntimeException e) {
			System.err.println("Catched exception " + e);
		}
	}

	private static void classCastException(Object someRef) {
		Foo f = (Foo) someRef;
	}

	private static void nullPointerGenerator(Object someRef) {
		someRef.toString();
	}
	

}
