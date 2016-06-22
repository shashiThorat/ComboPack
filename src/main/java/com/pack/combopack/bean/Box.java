package com.pack.combopack.bean;

import java.util.List;
import java.util.stream.Collectors;

public class Box<T extends Packable> implements BinPack<T> {

    private int id;
    private List<T> bins;
    private double capacity;

    public Box() {

    }

    public Box(int id, List<T> bins, double capacity) {
        super();
        this.id = id;
        this.bins = bins;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<T> getBins() {
        return bins;
    }

    public void setBins(List<T> bins) {
        this.bins = bins;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    @Override
    public List<T> getPackableBins() {

        return bins.stream().filter(x -> x.getWeight() <= capacity).collect(Collectors.toList());

    }

}
