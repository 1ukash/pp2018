package ru.spbstu.tema.pp.lecture04;

public abstract class Shape implements Colored, Material {
	
	private Coords coords;
	private int color;
	private int material;
	
	public Shape(Coords coords, int color, int material) {
		super();
		this.color = color;
		this.material = material;
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
	
	@Override
	public int getColor() {
		return color;
	}

	@Override
	public int getMaterial() {
		return material;
	}
	
	abstract double getSquare();
}
