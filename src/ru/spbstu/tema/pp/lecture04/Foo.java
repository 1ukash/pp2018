package ru.spbstu.tema.pp.lecture04;

public class Foo {

	private String name;
	private int id;
	private final Integer anotherId;
	private final int oneMoreId = 2;
	private static long num;
	
	{
		id = 2;
	}
	
	static {
		num = 3;
	}

	public Foo(String name, int id, int anotherId) {
		super();
		this.name = name;
		this.id = id;
		this.anotherId = anotherId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static long getNum() {
		return num;
	}

	public static void setNum(long num) {
		Foo.num = num;
	}

}
