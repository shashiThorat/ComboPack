package com.pack.combopack.packer;

import com.pack.combopack.bean.BinPack;
import com.pack.combopack.bean.Packable;
import com.pack.combopack.constraint.KnapsackPackagingValidator;
import com.pack.combopack.constraint.PackagingValidator;
import com.pack.combopack.exception.PackagingException;

public abstract class AbstractKnapSackPackager implements PackagingValidator, KnapsackPackager {

    protected static final PackagingValidator DEFAULT_VALIDATOR = new KnapsackPackagingValidator();

    PackagingValidator validator;

    public AbstractKnapSackPackager() {
        validator = DEFAULT_VALIDATOR;
    }

   

    public <T extends Packable, B extends BinPack<T>> void validate(B inputPack) throws PackagingException {

        validator.validate(inputPack);
    }

    public PackagingValidator getValidator() {
        return validator;
    }

    public void setValidator(PackagingValidator validator) {
        this.validator = validator;
    }

}
