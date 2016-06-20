package com.pack.combopack.packer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.pack.combopack.bean.Packable;

public class GreedyPackager implements KnapsackPackager {

	@Override
	public <T extends Packable> List<T> pack(List<T> packables, double maxWeight) {

		//TODO: Need to AOP in future for separation of concern and remove validate  and removeUnwantedItems call
		validate(packables, maxWeight);
		packables=removeUnwantedItems(packables, maxWeight);
		if(packables.isEmpty() )
			return null;
		Collections.sort(packables, packables.get(0).profitableComparator());
		List<T> selectedForPacking = new ArrayList<T>();
		Double totalSelectItemWeght = 0d;
		for (T packable : packables) {
			if ((totalSelectItemWeght + packable.getWeight()) > maxWeight)
				continue;
			selectedForPacking.add(packable);
			totalSelectItemWeght += packable.getWeight();
		}

		return selectedForPacking;
	}

}
