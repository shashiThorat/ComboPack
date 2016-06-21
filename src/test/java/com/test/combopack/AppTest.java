package com.test.combopack;

import static com.test.combopack.moc.ItemProvider.availableBoxs;
import static com.test.combopack.moc.ItemProvider.getAvailableItems;

import java.util.Arrays;
import java.util.List;

import com.pack.combopack.bean.Box;
import com.pack.combopack.bean.Item;
import com.pack.combopack.exception.PackagingException;
import com.pack.combopack.packer.BruteForcePackager;
import com.pack.combopack.packer.DynamicPackager;
import com.pack.combopack.packer.GreedyPackager;
import com.pack.combopack.packer.KnapsackPackager;

/**
 * Unit test for simple App.
 */

public class AppTest {

	public static void main(String[] args) throws PackagingException{

		List<KnapsackPackager> packers = Arrays.asList(
				new BruteForcePackager(), 
				new DynamicPackager(),
				new GreedyPackager());
		
		for (KnapsackPackager packer : packers) {
			System.out.println("\n <!-- Packaging with : "+packer.getClass().getSimpleName() +"-->"); 
			for (Box<Item> box : availableBoxs) {
				List<Item> items = packer.pack(getAvailableItems(box.getId()),
						box.getMaxWeight());

				box.setItems(items);
				System.out.println(box);
			}
		}

	}
}
