package com.pack.combopack.packer;

import java.util.ArrayList;
import java.util.List;

import com.pack.combopack.bean.Packable;
import com.pack.combopack.constraint.PackagingValidator;
import com.pack.combopack.exception.PackagingException;

public interface KnapsackPackager {

	default <T extends Packable> PackagingValidator getConstraint(
			List<T> items, double maxWeight) {
		return null;
	}

	<T extends Packable> List<T> pack(List<T> items, double maxWeight)
			throws PackagingException;

	
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
