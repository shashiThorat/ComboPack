package com.pack.combopack.bean;

import java.util.List;

public interface BinPack {

    int getId();

    double getCapacity();

    <T extends Packable> List<T> getBins();

    // Returns all beans which weight is less than Capacity
    <T extends Packable> List<T> getPackableBins();

}
