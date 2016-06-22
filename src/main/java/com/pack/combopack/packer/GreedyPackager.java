package com.pack.combopack.packer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.pack.combopack.bean.BinPack;
import com.pack.combopack.bean.Packable;
import com.pack.combopack.exception.PackagingException;

public class GreedyPackager extends AbstractKnapSackPackager {

    Comparator<Packable> profitableComparator = (v1, v2) -> Double.compare(v2.getValue() / v2.getWeight(),
            v1.getValue() / v1.getWeight());

    @Override
    public <T extends Packable, B extends BinPack<T>> List<T> pack(B inputPack) throws PackagingException {

        validate(inputPack);

        List<T> packables = inputPack.getPackableBins();

        if (packables.isEmpty())
            return null;

        Collections.sort(packables, profitableComparator);
        List<T> selectedForPacking = new ArrayList<T>();

        Double totalSelectItemWeght = 0d;

        for (T packable : packables) {
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

    public void setProfitableComparator(Comparator<Packable> profitableComparator) {
        this.profitableComparator = profitableComparator;
    }

}
