package ru.spbstu.tema.pp.lecture05;

public class MyImmutableObj {
	private int state;

	public MyImmutableObj(int state) {
		super();
		this.state = state;
	}

	public int getState() {
		return state;
	}
	
	public MyImmutableObj mutate(int newState) {
		return new MyImmutableObj(newState);
	}
	
}
