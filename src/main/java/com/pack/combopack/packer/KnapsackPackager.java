package com.pack.combopack.packer;

import java.util.List;

import com.pack.combopack.bean.BinPack;
import com.pack.combopack.bean.Packable;
import com.pack.combopack.exception.PackagingException;

public interface KnapsackPackager {

    <T extends Packable, B extends BinPack<T>> List<T> pack(B inputPack) throws PackagingException;

    
    default <T extends Packable> double getTotalWeight(List<T> items) {

        return null == items || items.isEmpty() ? 0.0 : items.stream().mapToDouble(T::getWeight).sum();
    }

    
    default <T extends Packable> Double getTotalPrice(List<T> items) {

        return null == items || items.isEmpty() ? 0.0 : items.stream().mapToDouble(T::getValue).sum();
    }

}
