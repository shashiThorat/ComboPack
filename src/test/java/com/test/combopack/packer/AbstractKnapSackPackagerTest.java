package com.test.combopack.packer;

import static com.test.combopack.moc.ItemProvider.getAvailableItems;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.pack.combopack.bean.Box;
import com.pack.combopack.bean.Item;
import com.pack.combopack.packer.KnapsackPackager;

public abstract class AbstractKnapSackPackagerTest {

    protected KnapsackPackager packer;

    @Test(expected = IllegalArgumentException.class)
    public void packWithNULL() {
        packer.pack(null);

    }

    @Test(expected = IllegalArgumentException.class)
    public void packWithNullItems() {
        packer.pack(new Box<Item>(1, null, 1d));

    }

    @Test(expected = IllegalArgumentException.class)
    public void packWithEmptyItems() {
        packer.pack(new Box<Item>(1, new ArrayList<Item>(), 1d));

    }

    @Test(expected = IllegalArgumentException.class)
    public void packWithInvalidWeight() {
        packer.pack(new Box<Item>(1, getAvailableItems(0), 0.0d));
    }

    @Test(expected = IllegalArgumentException.class)
    public void packWithMaxCapacity() {
        packer.pack(new Box<Item>(1, getAvailableItems(0), 101d));

    }

    @Test(expected = IllegalArgumentException.class)
    public void packWithMaxOverFullItems() {
        List<Item> overFillList = new ArrayList<Item>(getAvailableItems(3));
        overFillList.addAll(getAvailableItems(3));
        packer.pack(new Box<Item>(1, overFillList, 98d));

    }

    @Test(expected = IllegalArgumentException.class)
    public void packWithItemWtViolation() {
        List<Item> list = new ArrayList<Item>(getAvailableItems(3));
        list.get(0).setWeight(101d);
        packer.pack(new Box<Item>(1, list, 100d));

    }

    @Test(expected = IllegalArgumentException.class)
    public void packWithItemValuetViolation() {
        List<Item> list = new ArrayList<Item>(getAvailableItems(3));
        list.get(0).setValue(101);
        packer.pack(new Box<Item>(1, list, 100d));

    }

}
