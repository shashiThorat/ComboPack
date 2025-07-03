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

	

	
	
  

}
