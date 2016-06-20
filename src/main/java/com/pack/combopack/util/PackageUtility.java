package com.pack.combopack.util;

import java.util.List;

import com.pack.combopack.bean.Packable;

public class PackageUtility {

	public static <T extends Packable> double getTotalWeight(List<T> items) {

		return null == items || items.isEmpty() ? 0.0 : items.stream()
				.mapToDouble(T::getWeight).sum();
	}

	public static <T extends Packable> Double getTotalPrice(List<T> items) {

		return null == items || items.isEmpty() ? 0.0 : items.stream()
				.mapToDouble(T::getValue).sum();
	}

}
