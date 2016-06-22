package com.pack.combopack.constraint;

import com.pack.combopack.bean.BinPack;
import com.pack.combopack.bean.Packable;
import com.pack.combopack.exception.PackagingException;

public interface PackagingValidator {
	
    <T extends Packable, B extends BinPack<T>> void validate(B inputPack) throws PackagingException;
}
