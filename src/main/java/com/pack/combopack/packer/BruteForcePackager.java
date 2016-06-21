package com.pack.combopack.packer;

import static com.pack.combopack.util.PackageUtility.getTotalPrice;
import static com.pack.combopack.util.PackageUtility.getTotalWeight;
import static com.pack.combopack.util.PowerSetUtility.genratePowerSet;

import java.util.List;

import com.pack.combopack.bean.Packable;
import com.pack.combopack.exception.PackagingException;

public class BruteForcePackager extends AbstractKnapSackPackager {

	@Override
	public <T extends Packable> List<T> pack(List<T> packables, double maxWeight)throws PackagingException {
		//TODO: Need to AOP in future for separation of concern and remove validate  and removeUnwantedItems call
		
		validate(packables, maxWeight);
		packables=removeUnwantedItems(packables, maxWeight);
		List<List<T>> powerSet = genratePowerSet(packables);
		List<T> maxPriceItems = null;
		double maxPrice = 0d;

		for (List<T> list : powerSet) {

			double currentItemsWeight = getTotalWeight(list);

			if (currentItemsWeight <= maxWeight) {
				double currentItemsValue = getTotalPrice(list);

				if (currentItemsValue > maxPrice) {
					maxPriceItems = list;
					maxPrice = currentItemsValue;
				} else if (currentItemsValue == maxPrice
						&& currentItemsWeight < getTotalWeight(maxPriceItems)) {

					maxPriceItems = list;

				}
			}
		}

		return maxPriceItems;
	}

}
