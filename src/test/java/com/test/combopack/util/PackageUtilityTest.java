package com.test.combopack.util;

import static com.pack.combopack.util.PackageUtility.getTotalPrice;
import static com.pack.combopack.util.PackageUtility.getTotalWeight;
import static com.test.combopack.moc.ItemProvider.getAvailableItems;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PackageUtilityTest {

	@Test
	public void getWeight() {
		assertEquals(getTotalWeight(getAvailableItems(0)), 1, 0.001);
	}

	@Test
	public void getPrice() {
		assertEquals(getTotalPrice(getAvailableItems(0)), 3, 0.001);
	}

	@Test
	public void getWeightNullItems() {
		assertEquals(getTotalWeight(null), 0, 0.001);
	}

	@Test
	public void getPriceNullItems() {
		assertEquals(getTotalPrice(null), 0, 0.001);
	}
}
