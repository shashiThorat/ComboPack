package com.pack.combopack.constraint;

import com.pack.combopack.bean.BinPack;
import com.pack.combopack.bean.Packable;
import com.pack.combopack.exception.PackagingException;

public class KnapsackPackagingValidator implements PackagingValidator {

    private double maxCapacity;
    private int maxPacakableItems;
    private double maxItemWt;
    private double maxItemValue;

    public KnapsackPackagingValidator() {

        this.maxCapacity = 100;
        this.maxPacakableItems = 15;
        this.maxItemWt = 100;
        this.maxItemValue = 100;

    }

    @Override
    public <T extends Packable, B extends BinPack<T>> void validate(B inputPack) throws PackagingException {

        if (inputPack == null || inputPack.getBins() == null || inputPack.getBins().isEmpty()
                || inputPack.getCapacity() <= 0)
            throw new PackagingException(
                    "Packaging inputs are invalid.Required atleast on packable Item and allowed weight should be greater than 0 ");

        if (inputPack.getBins().size() > maxPacakableItems || inputPack.getCapacity() > maxCapacity)
            throw new PackagingException("Maximum  " + maxPacakableItems
                    + " input Items are allowed and Maximum weight should be less than " + maxCapacity);

        // Check any bin weight and value is more than specified limit
        if (inputPack.getBins().stream().anyMatch(x -> x.getWeight() > maxItemWt || x.getValue() > maxItemValue))

            throw new PackagingException("Each packable item Maximum allowed weight is" + maxItemWt + " and value is "
                    + maxItemValue);

    }

}
