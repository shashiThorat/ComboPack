package com.pack.combopack.packer;

import static com.pack.combopack.util.PowerSetUtility.genratePowerSet;

import java.util.List;

import com.pack.combopack.bean.BinPack;
import com.pack.combopack.bean.Packable;

public final class BruteForcePackager extends AbstractKnapSackPackager {

    @Override
    // <T extends Packable, B extends BinPack<T>>
    public  List<Packable> pack(BinPack inputPack)  {

        validate(inputPack);

        List<Packable> packables = inputPack.getPackableBins();

        List<List<Packable>> powerSet = genratePowerSet(packables);

        List<Packable> maxPriceItems = null;

        double maxPrice = 0d;

        for (List<Packable> list : powerSet) {

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
