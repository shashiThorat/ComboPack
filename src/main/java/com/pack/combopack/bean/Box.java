package com.pack.combopack.bean;

import java.util.List;



public class Box<T extends Packable> {
	private int id;
	private  List<T> items;
    private double maxWeight;
	
	public Box(int id ,double maxWeight) {
		
		this.maxWeight=maxWeight;
		this.id = id;
	}

	

	@Override
	public String toString() {
		return "Box [id=" + id + ", items=" + items + "]";
	}

	public int getId() {
		return id;
	}

	public double getMaxWeight() {
		return maxWeight;
	}



	public void setItems(List<T> itemList) {
		this.items = itemList;
	}

	
  

}
