package ru.spbstu.tema.pp.lecture04;

public abstract class Shape implements Colored, Material {
	
	private Coords coords;
	
	public Shape(Coords coords) {
		super();
		this.coords = coords;
	}

	public Coords getCoords() {
		return coords;
	}

	public void setCoords(Coords coords) {
		this.coords = coords;
	}
	
	void doRoutines() {
		getSquare();
	}
	
	abstract double getSquare();
}
