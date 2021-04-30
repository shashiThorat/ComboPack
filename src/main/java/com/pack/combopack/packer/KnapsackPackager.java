package com.pack.combopack.packer;

import java.util.List;

import com.pack.combopack.bean.BinPack;
import com.pack.combopack.bean.Packable;

public interface KnapsackPackager {

    double DEFAULT_MAX_CAPACITY = 100;
    int DEFAULT_ALLOWED_ITEMS = 15;
    double DEFAULT_MAX_ITEM_WT = 100;
    double DEFAULT_MAX_ITEM_VALUE = 100;

    List<Packable> pack(BinPack inputPack);

    default double getTotalWeight(List<Packable> items) {

        return null == items || items.isEmpty() ? 0.0 : items.stream().mapToDouble(Packable::getWeight).sum();
    }

    default <T extends Packable> double getTotalPrice(List<T> items) {

        return null == items || items.isEmpty() ? 0.0 : items.stream().mapToDouble(T::getValue).sum();
    }

}
