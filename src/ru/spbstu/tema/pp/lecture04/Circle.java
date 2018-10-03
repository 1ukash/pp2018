package ru.spbstu.tema.pp.lecture04;

public class Circle extends Shape {
	
	private int radius;
	private int color;
	private int material;

	public Circle(Coords coords, int radius, int color, int material) {
		super(coords);
		this.radius = radius;
		this.color = color;
		this.material = material;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	double getSquare() {
		return Math.PI * radius * radius;
	}

	@Override
	public int getColor() {
		return color;
	}

	@Override
	public int getMaterial() {
		return material;
	}
}
