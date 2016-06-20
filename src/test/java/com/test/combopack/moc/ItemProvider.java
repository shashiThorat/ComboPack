package com.test.combopack.moc;

import java.util.Arrays;
import java.util.List;

import com.pack.combopack.bean.Box;
import com.pack.combopack.bean.Item;


public class ItemProvider {

	public static List<Box<Item>> availableBoxs=Arrays.asList(
			new Box<Item>(1, 81d),
			new Box<Item>(2, 8d),
			new Box<Item>(3, 75d),
			new Box<Item>(4, 56d)
			);
			
	
	public static List<Item> getAvailableItems(int id) {
		
		switch (id) {
		case 1:
			return 
					Arrays.asList(
							new Item(1, 53.38, 45d), 
							new Item(2, 88.62,98d), 
							new Item(3, 78.48, 3d), 
							new Item(4, 72.30, 76d),
							new Item(5, 30.18, 9d),
							new Item(6, 46.34, 48d));

		case 2:
			return 
					Arrays.asList(new Item(1, 15.3, 34d));

		case 3:
			return 
					Arrays.asList(
							new Item(1, 85.31, 29d), 
							new Item(2, 14.55,74d), 
							new Item(3, 3.98, 16d),
							new Item(4, 26.24, 55d),
							new Item(5, 63.69, 52d), 
							new Item(6, 76.25, 75d), 
							new Item(7, 60.02, 74d), 
							new Item(8, 93.18, 35d), 
							new Item(9, 89.95, 78d));
		case 4:
			return 
					Arrays.asList(
							new Item(1, 90.72, 13d), 
							new Item(2, 33.80,40d), 
							new Item(3, 43.15, 10d), 
							new Item(4, 37.97, 16d),
							new Item(5, 46.81, 36d), 
							new Item(6, 48.77, 79d), 
							new Item(7, 81.80, 45d), 
							new Item(8, 19.36, 79d), 
							new Item(9, 6.76, 64d));
		case 0:
			return 
					Arrays.asList(
							new Item(1, 0.5, 1d), 
							new Item(2, 0.5, 2d));

		}

		return null;
	}
}
