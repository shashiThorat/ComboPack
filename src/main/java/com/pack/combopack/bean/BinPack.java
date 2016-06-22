package com.pack.combopack.bean;

import java.util.List;

public interface BinPack<T> {

    int getId();

    double getCapacity();

    List<T> getBins();
    
    //Returns all beans which weight is less than Capacity  
    List<T> getPackableBins();

}
