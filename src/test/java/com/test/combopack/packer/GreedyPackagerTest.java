package com.test.combopack.packer;

import static com.pack.combopack.util.PackageUtility.getTotalWeight;
import static com.test.combopack.moc.ItemProvider.availableBoxs;
import static com.test.combopack.moc.ItemProvider.getAvailableItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.pack.combopack.bean.Box;
import com.pack.combopack.bean.Item;
import com.pack.combopack.packer.GreedyPackager;
import com.pack.combopack.packer.KnapsackPackager;

public class GreedyPackagerTest {
	KnapsackPackager packer = new GreedyPackager();

	@Test
	public void pack() {
		for (Box<Item> box : availableBoxs) {
			List<Item> items = packer.pack(getAvailableItems(box.getId()),
					box.getMaxWeight());
			assertTrue(getTotalWeight(items) < box.getMaxWeight());
			box.setItems(items);
			System.out.println(box);
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void packWithNULLItems() {
		packer.pack(null, 1.0d);

	}

	@Test(expected = IllegalArgumentException.class)
	public void packWithEmptyItems() {
		packer.pack(new ArrayList<Item>(), 1.0d);

	}

	@Test(expected = IllegalArgumentException.class)
	public void packWithInvalidWeight() {
		packer.pack(getAvailableItems(0), 0.0d);
	}

	@Test
	public void packWithValidInput() {
		List<Item> items = packer.pack(getAvailableItems(0), 0.5d);
		assertEquals("Total Size", items.size(), 1);
		assertEquals(items.get(0).getValue(), 2.0, 0.01);
	}

}
