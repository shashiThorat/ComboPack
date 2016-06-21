package com.pack.combopack.constraint;

import java.util.List;

import com.pack.combopack.bean.Packable;
import com.pack.combopack.exception.PackagingException;

public class KnapsackPackagingValidator implements PackagingValidator {
	
	private double maxCapacity;
	private int maxPacakableItems;
	private double maxItemWt;
	private double maxItemValue; 

	

	public KnapsackPackagingValidator() {
		//TODO Need initialization from property bundle 
		this.maxCapacity = 100;
		this.maxPacakableItems = 15;
		this.maxItemWt = 100;
		this.maxItemValue = 100;
		
	}



	public KnapsackPackagingValidator(double maxCapacity,
			int maxPacakableItems, double maxItemWt, double maxItemValue) {
		super();
		this.maxCapacity = maxCapacity;
		this.maxPacakableItems = maxPacakableItems;
		this.maxItemWt = maxItemWt;
		this.maxItemValue = maxItemValue;
	}



	@Override
	public <T extends Packable> void validate(List<T> items, double maxWeight) throws PackagingException{
		
		if (items.size()> maxPacakableItems|| maxWeight > maxCapacity)
			throw new PackagingException(
					"Maximum  "+maxPacakableItems+" input Items are allowed and Maximum weight should be less than "+maxCapacity);
		
		if(items.stream().anyMatch(x->x.getWeight() >maxItemWt || x.getValue() >maxItemValue ))
	
			throw new PackagingException(
					"Each packable item Maximum allowed weight is"+maxItemWt+" and value is "+maxItemValue);
		
	}

}
