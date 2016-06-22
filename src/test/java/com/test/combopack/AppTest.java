package com.test.combopack;

import static com.test.combopack.moc.ItemProvider.availableBoxs;
import static org.junit.Assert.assertTrue;

import java.util.List;

import com.pack.combopack.bean.Box;
import com.pack.combopack.bean.Item;
import com.pack.combopack.exception.PackagingException;
import com.pack.combopack.packer.KnapsackPackager;
import com.test.combopack.packer.KnapsackPackagerTest;


public class AppTest {

	public static void main(String[] args) throws PackagingException{

		
		
		for (KnapsackPackager packer : KnapsackPackagerTest.getAllPackagers()) {
			System.out.println("\n <!-- Packaging with : "+packer.getClass().getSimpleName() +"-->"); 
			 for (Box<Item> box : availableBoxs) {
		            List<Item> items = packer.pack(box);
		            assertTrue(packer.getTotalWeight(items) < box.getCapacity());
		          
		            System.out.println("Id :" + box.getId() +" "+ items);
		        }
		}

	}
}
