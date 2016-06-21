package com.pack.combopack.constraint;

import java.util.List;

import com.pack.combopack.bean.Packable;
import com.pack.combopack.exception.PackagingException;

public interface PackagingValidator {
	
	<T extends Packable> void validate(List<T> items, double maxWeight) throws PackagingException;
}
