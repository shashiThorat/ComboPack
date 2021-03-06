package com.pack.combopack.packer;

import java.util.ArrayList;
import java.util.List;

import com.pack.combopack.bean.Packable;
import com.pack.combopack.exception.PackagingException;

public class DynamicPackager extends AbstractKnapSackPackager {

	// @Override
	public <T extends Packable> List<T> pack(List<T> packables, double maxWeight)throws PackagingException {
		
		//TODO: Need to AOP in future for separation of concern and remove validate  and removeUnwantedItems call
		
		validate(packables, maxWeight);
		packables=removeUnwantedItems(packables, maxWeight);
		List<T> tempList = new ArrayList<T>();

		int n = packables.size();

		if (n > 0 && maxWeight > 0) {
			List<List<Integer>> c = new ArrayList<List<Integer>>();
			List<Integer> curr = new ArrayList<Integer>();

			c.add(curr);
			for (int j = 0; j <= maxWeight * 100; j++)
				curr.add(0);
			for (int i = 1; i <= n; i++) {
				List<Integer> prev = curr;
				c.add(curr = new ArrayList<Integer>());
				for (int j = 0; j <= maxWeight * 100; j++) {
					if (j > 0) {
						int wH = (int) (packables.get(i - 1).getWeight() * 100);
						curr.add((wH >= j) ? prev.get(j) : Math.max(
								prev.get(j),

								(int) packables.get(i - 1).getValue()
										+ prev.get(j - wH)));
					} else {
						curr.add(0);
					}
				}
			}

			for (int i = n, j = (int)(maxWeight* 100); i > 0 && j >= 0; i--) {
				int tempI = c.get(i).get(j);
				int tempI_1 = c.get(i - 1).get(j);
				if ((i == 0 && tempI > 0) || (i > 0 && tempI != tempI_1)) {
					tempList.add(packables.get(i - 1));
					int wH = (int) (packables.get(i - 1).getWeight() * 100);

					j -= wH;

				}
			}

		}
		return tempList.isEmpty()?null:tempList;
	}

}
