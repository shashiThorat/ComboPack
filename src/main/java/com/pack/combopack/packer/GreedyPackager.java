package com.pack.combopack.packer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.pack.combopack.bean.BinPack;
import com.pack.combopack.bean.Packable;

public final class GreedyPackager extends AbstractKnapSackPackager {

   final private Comparator<Packable> profitableComparator = (v1, v2) -> Double.compare(v2.getValue() / v2.getWeight(),
            v1.getValue() / v1.getWeight());

    @Override
    public List<Packable> pack(BinPack inputPack)  {

        validate(inputPack);

        List<Packable> packables = inputPack.getPackableBins();

        if (packables.isEmpty())
            return null;

        Collections.sort(packables, profitableComparator);
        List<Packable> selectedForPacking = new ArrayList<Packable>();

        Double totalSelectItemWeght = 0d;

        for (Packable packable : packables) {
            if ((totalSelectItemWeght + packable.getWeight()) > inputPack.getCapacity())
                continue;
            selectedForPacking.add(packable);
            totalSelectItemWeght += packable.getWeight();
        }

        return selectedForPacking;
    }

    public Comparator<Packable> getProfitableComparator() {
        
        return profitableComparator;
    }

   

}
