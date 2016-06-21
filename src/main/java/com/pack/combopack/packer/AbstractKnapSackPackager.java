package com.pack.combopack.packer;

import java.util.List;

import com.pack.combopack.bean.Packable;
import com.pack.combopack.constraint.KnapsackPackagingValidator;
import com.pack.combopack.constraint.PackagingValidator;
import com.pack.combopack.exception.PackagingException;

public abstract class AbstractKnapSackPackager implements PackagingValidator,
		KnapsackPackager {

	protected static final PackagingValidator DEFAULT_VALIDATOR = new KnapsackPackagingValidator();

	PackagingValidator validator;

	public AbstractKnapSackPackager() {
		validator = DEFAULT_VALIDATOR;
	}

	public AbstractKnapSackPackager(PackagingValidator validator) {

		this.validator = validator;
	}

	public <T extends Packable> void validate(List<T> items, double maxWeight)
			throws PackagingException {
		if (items == null || items.isEmpty() || maxWeight <= 0)
			throw new PackagingException(
					"Packaging inputs are invalid.Required atleast on packable Iteam and alloewed weight should be greater than 0 ");
		
		validator.validate(items, maxWeight);
	}

	public PackagingValidator getValidator() {
		return validator;
	}

	public void setValidator(PackagingValidator validator) {
		this.validator = validator;
	}

}
