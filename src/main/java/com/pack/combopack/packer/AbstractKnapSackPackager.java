package com.pack.combopack.packer;

import java.util.List;

import com.pack.combopack.bean.BinPack;
import com.pack.combopack.bean.Packable;

public abstract class AbstractKnapSackPackager implements KnapsackPackager {

    private final double maxCapacity;

    private final int maxAllowedItems;
    private final double maxItemWt;
    private final double maxItemValue;

    public AbstractKnapSackPackager() {
        this.maxCapacity = DEFAULT_MAX_CAPACITY;
        this.maxAllowedItems = DEFAULT_ALLOWED_ITEMS;
        this.maxItemWt = DEFAULT_MAX_ITEM_WT;
        this.maxItemValue = DEFAULT_MAX_ITEM_VALUE;

    }

    public AbstractKnapSackPackager(double maxCapacity, int maxAllowedItems, double maxItemWt, double maxItemValue) {
        super();
        this.maxCapacity = maxCapacity;
        this.maxAllowedItems = maxAllowedItems;
        this.maxItemWt = maxItemWt;
        this.maxItemValue = maxItemValue;
    }

    protected boolean isValidInputWt(double inputWt) {

        return inputWt <= 0 || inputWt > maxCapacity ? false : true;

    }

    protected boolean isValidInputPackable(List<Packable> packables) {

        if (packables != null && !packables.isEmpty() && packables.size() < maxAllowedItems) {

            return packables.stream()

            .allMatch(x -> x.getWeight() < maxItemWt && x.getValue() < maxItemValue);

        }
        return false;

    }

    boolean isValidBinPack(BinPack inputPack) {

        return inputPack != null

        && isValidInputWt(inputPack.getCapacity())

        && isValidInputPackable(inputPack.getBins());

    }

    public void validate(BinPack inputPack) {

        if (!isValidBinPack(inputPack)) {

            throw new IllegalArgumentException("Invalid Packing Inputs");

        }
    }
}
