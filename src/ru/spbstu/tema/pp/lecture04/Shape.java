package ru.spbstu.tema.pp.lecture04;

public abstract class Shape implements Colored, Materialized {

	class PhysicParams { //start next lecture about inner classes, anonymous, etc
		double mass;
		int age;

		public PhysicParams(double mass, int age) {
			super();
			this.mass = mass;
			this.age = age;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
	}

	private Coords coords;
	private Color color;
	private Material material;

	public Shape(Coords coords, Color color, Material material) {
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
	public Color getColor() {
		return color;
	}

	@Override
	public Material getMaterial() {
		return material;
	}

	abstract double getSquare();
}
