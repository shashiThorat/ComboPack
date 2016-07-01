package com.test.combopack;

import static com.test.combopack.moc.ItemProvider.availableBoxs;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import com.pack.combopack.bean.Box;
import com.pack.combopack.bean.Item;
import com.pack.combopack.bean.Packable;
import com.pack.combopack.packer.BruteForcePackager;
import com.pack.combopack.packer.DynamicPackager;
import com.pack.combopack.packer.GreedyPackager;
import com.pack.combopack.packer.KnapsackPackager;

public class AppTest {

    public static void main(String[] args) {

    List<KnapsackPackager> packers=    Arrays.asList(new BruteForcePackager(), new GreedyPackager(), new DynamicPackager());
        for (KnapsackPackager packer : packers) {
            System.out.println("\n <!-- Packaging with : " + packer.getClass().getSimpleName() + "-->");
            for (Box<Item> box : availableBoxs) {
                List<Packable> items = packer.pack(box);
                assertTrue(packer.getTotalWeight(items) < box.getCapacity());

                System.out.println("Id :" + box.getId() + " " + items);
            }
        }

    }
}
