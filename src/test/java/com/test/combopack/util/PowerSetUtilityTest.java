package com.test.combopack.util;

import static com.pack.combopack.util.PowerSetUtility.genratePowerSet;
import static com.test.combopack.moc.ItemProvider.getAvailableItems;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.pack.combopack.bean.Item;

public class PowerSetUtilityTest {

	@Test
	public void genrateSet() {
		
		List<List<Item>> items=genratePowerSet(getAvailableItems(0));
		assertEquals("", items.size(), 4);
		

	}
	@Test
	public void genrateIntegerSet() {
		
		List<List<Integer>> items=genratePowerSet(Arrays.asList(1,2));
		assertEquals("", items.size(), 4);
		

	}
	@Test
	public void genrateNullSet() {
		
		List<List<Integer>> items=genratePowerSet(null);
		assertEquals("", items.size(), 0);
		

	}
	@Test
	public void genrateEmptySet() {
		
		List<List<Integer>> items=genratePowerSet(new ArrayList<Integer>());
		assertEquals("", items.size(), 0);
		

	}

}
