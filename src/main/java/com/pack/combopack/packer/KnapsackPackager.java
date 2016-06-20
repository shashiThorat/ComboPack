package com.pack.combopack.packer;

import java.util.ArrayList;
import java.util.List;

import com.pack.combopack.bean.Packable;

public interface KnapsackPackager {

	<T extends Packable> List<T> pack(List<T> items, double maxWeight);

	default <T extends Packable> void validate(List<T> items, Double maxWeight) {
		if (items == null || items.isEmpty() || maxWeight <= 0)
			throw new IllegalArgumentException(
					"Packaging inputs are invalid.Required atleast on packable Iteam and alloewed weight should be greater than 0 ");

	}

	default <T extends Packable> List<T> removeUnwantedItems(List<T> items,
			Double maxWeight) {
		
		List<T> itemsForSelection = new ArrayList<T>();
		for (T packable : items) {
			if (packable.getWeight() <= maxWeight)
				itemsForSelection.add(packable);
		}
		
		return itemsForSelection;

	}

}
