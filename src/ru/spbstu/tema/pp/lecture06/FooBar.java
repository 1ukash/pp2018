package ru.spbstu.tema.pp.lecture06;

import java.io.Serializable;

public class FooBar implements Serializable {
	private int id;
	private String value;
	private double coef;
	
	private transient Object connection; //ignore this field during writing object to Stream
	
	FooBar myself;
	
	public FooBar(int id, String value, double coef) {
		super();
		this.id = id;
		this.value = value;
		this.coef = coef;
		myself = this;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getCoef() {
		return coef;
	}

	public void setCoef(double coef) {
		this.coef = coef;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return id + " : " + value + " : " + coef;
	}

	public FooBar getMyself() {
		return myself;
	}
}
