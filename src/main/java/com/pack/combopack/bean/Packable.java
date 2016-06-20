package com.pack.combopack.bean;

import java.util.Comparator;



public interface Packable {
	
	public double getWeight();
	public double getValue();
	public default <T extends Packable> Comparator<T> profitableComparator() {
		
		return  (v1, v2) -> Double.compare(v2.getValue()/v2.getWeight(), v1.getValue()/v1.getWeight());
	
	}
	
	

}
