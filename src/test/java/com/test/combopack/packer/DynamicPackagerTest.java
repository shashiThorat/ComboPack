package com.test.combopack.packer;

import static com.test.combopack.moc.ItemProvider.availableBoxs;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.pack.combopack.bean.Box;
import com.pack.combopack.bean.Item;
import com.pack.combopack.bean.Packable;
import com.pack.combopack.packer.DynamicPackager;

public class DynamicPackagerTest extends AbstractKnapSackPackagerTest {

    @Before
    public void init() {
        packer = new DynamicPackager();
    }

    @Test
    public void pack() {

        System.out.println("\n <!-- Packaging with : " + packer.getClass().getSimpleName() + "-->");

        for (Box<Item> box : availableBoxs) {

            List<Packable> items = packer.pack(box);
            assertTrue(packer.getTotalWeight(items) < box.getCapacity());

            System.out.println("Id :" + box.getId() + " " + items);
        }
    }
}