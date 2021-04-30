package com.pack.combopack.bean;

public class Item implements Packable {

    private int id;
    private double weight;
    private double value;

    public Item(int id, double weight, double value) {
        this.id = id;
        this.weight = weight;
        this.value = value;
    }

    @Override
    public double getWeight() {

        return weight;

    }

    @Override
    public double getValue() {

        return value;
    }

    @Override
    public String toString() {
        return "" + id;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setValue(double value) {
        this.value = value;
    }

}
