package ru.spbstu.tema.pp.lecture05;

public class InnerExamples {

	private int f1;
	private String str1;
	
	class Inner {
		int x;
		
		public Inner(int x) {
			super();
			this.x = x;
		}

		public int doSmthWithF1AndReturn() {
			return f1 * x;
		}
		
	}
	
	static class StaticInner {
		
	}

	public int getF1() {
		return f1;
	}

	public void setF1(int f1) {
		this.f1 = f1;
	}

	private void foo() {
		// TODO Auto-generated method stub

	}
	
	private void bar() {
		// TODO Auto-generated method stub

	}
	
	public Inner baz() {
		return new Inner(10);
	}
	
	public static void main(String[] args) {
		//Inner i = new Inner(1);
	}
}
