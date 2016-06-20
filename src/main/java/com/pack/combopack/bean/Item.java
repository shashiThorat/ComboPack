package com.pack.combopack.bean;

public class Item implements Packable {

	private int id;
	private double weight;
	private double value;

	public Item(int id, double weight, double value) {
		this.id = id;
		this.weight = weight;
		this.value = value;
	}

	@Override
	public double getWeight() {
		// TODO Auto-generated method stub
		return weight;
	}

	@Override
	public double getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public String toString() {
		return ""+id ;
	}

}
