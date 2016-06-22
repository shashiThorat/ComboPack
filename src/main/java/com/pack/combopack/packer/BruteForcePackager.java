package com.pack.combopack.packer;

import static com.pack.combopack.util.PowerSetUtility.genratePowerSet;

import java.util.List;

import com.pack.combopack.bean.BinPack;
import com.pack.combopack.bean.Packable;
import com.pack.combopack.exception.PackagingException;

public class BruteForcePackager extends AbstractKnapSackPackager {

    @Override
    public <T extends Packable, B extends BinPack<T>> List<T> pack(B inputPack) throws PackagingException {

        validate(inputPack);

        List<T> packables = inputPack.getPackableBins();

        List<List<T>> powerSet = genratePowerSet(packables);

        List<T> maxPriceItems = null;

        double maxPrice = 0d;

        for (List<T> list : powerSet) {

            double currentItemsWeight = getTotalWeight(list);

            if (currentItemsWeight <= inputPack.getCapacity()) {

                double currentItemsValue = getTotalPrice(list);

                if (currentItemsValue > maxPrice) {
                    maxPriceItems = list;
                    maxPrice = currentItemsValue;
                } else if (currentItemsValue == maxPrice && currentItemsWeight < getTotalWeight(maxPriceItems)) {

                    maxPriceItems = list;

                }
            }
        }

        return maxPriceItems;
    }

}
