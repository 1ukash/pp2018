package ru.spbstu.tema.pp.lecture04;

public class StartHere {

	public static void main(String[] args) {

		Foo f = new Foo("First obj", 11, 7);
		System.out.println(f.getName());

		Object o = new Circle(new Coords(1, 1), 10, Color.BLACK, Material.METAL);
		Circle c = new Circle(new Coords(1, 1), 10, Color.RED, Material.WOOD);

		System.out.println(c instanceof Circle);

		if (o instanceof Shape) {
			System.out.println("object is shape");

			Circle c2 = (Circle) o;

			if (c2 == c) {
				System.out.println("objects are the same");
			}
		}

		// Shape p = new Shape(new Coords(2, 2));

	}
}
