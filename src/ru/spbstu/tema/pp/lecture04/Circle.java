package ru.spbstu.tema.pp.lecture04;

public class Circle extends Shape {
	
	private int radius;
	

	public Circle(Coords coords, int radius, Color color, Material material) {
		super(coords, color, material);
		this.radius = radius;
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


}
