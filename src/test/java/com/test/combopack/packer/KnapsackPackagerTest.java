package com.test.combopack.packer;

import static com.test.combopack.moc.ItemProvider.availableBoxs;
import static com.test.combopack.moc.ItemProvider.getAvailableItems;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.pack.combopack.bean.Box;
import com.pack.combopack.bean.Item;
import com.pack.combopack.exception.PackagingException;
import com.pack.combopack.packer.BruteForcePackager;
import com.pack.combopack.packer.DynamicPackager;
import com.pack.combopack.packer.GreedyPackager;
import com.pack.combopack.packer.KnapsackPackager;

@RunWith(Parameterized.class)
public class KnapsackPackagerTest {
    
   
    KnapsackPackager packer ;
    
    @Parameters
    public static Collection<KnapsackPackager> getAllPackagers() {

        return Arrays.asList(new BruteForcePackager(), new GreedyPackager(), new DynamicPackager());
    }


    public KnapsackPackagerTest(KnapsackPackager packer) {
        this.packer = packer;
    }

    @Test
    public void pack() throws PackagingException {

        System.out.println("\n <!-- Packaging with : " + packer.getClass().getSimpleName() + "-->");

        for (Box<Item> box : availableBoxs) {
            List<Item> items = packer.pack(box);
            assertTrue(packer.getTotalWeight(items) < box.getCapacity());
          
            System.out.println("Id :" + box.getId() +" "+ items);
        }
    }

    @Test(expected = PackagingException.class)
    public void packWithNULL() throws PackagingException {
        packer.pack(null);

    }
    
    @Test(expected = PackagingException.class)
    public void packWithNullItems() throws PackagingException {
        packer.pack(new Box<Item>(1, null, 1d));

    }

    @Test(expected = PackagingException.class)
    public void packWithEmptyItems() throws PackagingException {
        packer.pack(new Box<Item>(1, new ArrayList<Item>(), 1d));

    }

    @Test(expected = PackagingException.class)
    public void packWithInvalidWeight() throws PackagingException {
        packer.pack(new Box<Item>(1,getAvailableItems(0), 0.0d));
    }

    @Test
    public void packWithValidInput() throws PackagingException {
        List<Item> items = packer.pack(new Box<Item>(1,getAvailableItems(0), 1d));
        assertEquals("Total Size", items.size(), 1);
        assertEquals(items.get(0).getValue(), 2.0, 0.01);
    }

    @Test(expected = PackagingException.class)
    public void packWithMaxCapacity() throws PackagingException {
        packer.pack(new Box<Item>(1,getAvailableItems(0), 101d));

    }

    @Test(expected = PackagingException.class)
    public void packWithMaxOverFullItems() throws PackagingException {
        List<Item> overFillList = new ArrayList<Item>(getAvailableItems(3));
        overFillList.addAll(getAvailableItems(3));
        packer.pack(new Box<Item>(1,overFillList, 98d));

    }

    @Test(expected = PackagingException.class)
    public void packWithItemWtViolation() throws PackagingException {
        List<Item> list = new ArrayList<Item>(getAvailableItems(3));
        list.get(0).setWeight(101d);
        packer.pack(new Box<Item>(1,list, 100d));

    }

    @Test(expected = PackagingException.class)
    public void packWithItemValuetViolation() throws PackagingException {
        List<Item> list = new ArrayList<Item>(getAvailableItems(3));
        list.get(0).setValue(101);
        packer.pack(new Box<Item>(1,list, 100d));

    }

}
