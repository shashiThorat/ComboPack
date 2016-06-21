package com.test.combopack.packer;

import static com.pack.combopack.util.PackageUtility.getTotalWeight;
import static com.test.combopack.moc.ItemProvider.availableBoxs;
import static com.test.combopack.moc.ItemProvider.getAvailableItems;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Test;

import com.pack.combopack.bean.Box;
import com.pack.combopack.bean.Item;
import com.pack.combopack.exception.PackagingException;
import com.pack.combopack.packer.BruteForcePackager;
import com.pack.combopack.packer.KnapsackPackager;

public class BruteForcePackagerTest {

	KnapsackPackager packer = new BruteForcePackager();

	@Test
	public void pack() throws PackagingException {
		for (Box<Item> box : availableBoxs) {
			List<Item> items = packer.pack(getAvailableItems(box.getId()),
					box.getMaxWeight());
			assertTrue(getTotalWeight(items) < box.getMaxWeight());
			box.setItems(items);
			System.out.println(box);
		}
	}

	@Test(expected = PackagingException.class)
	public void packWithNULLItems() throws PackagingException {
		packer.pack(null, 1.0d);

	}

	@Test(expected = PackagingException.class)
	public void packWithEmptyItems() throws PackagingException {
		packer.pack(new ArrayList<Item>(), 1.0d);

	}

	@Test(expected = PackagingException.class)
	public void packWithInvalidWeight() throws PackagingException {
		packer.pack(getAvailableItems(0), 0.0d);
	}

	@Test
	public void packWithValidInput() throws PackagingException {
		List<Item> items = packer.pack(getAvailableItems(0), 0.5d);
		assertEquals("Total Size", items.size(), 1);
		assertEquals(items.get(0).getValue(), 2.0, 0.01);
	}

	@Test(expected = PackagingException.class)
	public void packWithMaxCapacity() throws PackagingException {
		packer.pack(getAvailableItems(0), 101d);

	}

	@Test(expected = PackagingException.class)
	public void packWithMaxOverFullItems() throws PackagingException {
		List<Item> overFillList = new ArrayList<Item>(getAvailableItems(3));
		overFillList.addAll(getAvailableItems(3));
		packer.pack(overFillList, 98d);

	}

	@Test(expected = PackagingException.class)
	public void packWithItemWtViolation() throws PackagingException {
		List<Item> list = new ArrayList<Item>(getAvailableItems(3));
		list.get(0).setWeight(101d);
		packer.pack(list, 100d);

	}

	@Test(expected = PackagingException.class)
	public void packWithItemValuetViolation() throws PackagingException {
		List<Item> list = new ArrayList<Item>(getAvailableItems(3));
		list.get(0).setValue(101);
		packer.pack(list, 100d);

	}

}
