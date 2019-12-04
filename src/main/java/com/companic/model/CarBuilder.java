package com.companic.model;

import com.companic.model.entity.Car;

public abstract class CarBuilder<B extends CarBuilder> {
    private long id;
    private String vendor;
    private String model;
    private int year;
    private Color color;
    private int maxSpeed;
    private int fuelConsumption;
    private int value;

    public B withId(long id) {
        this.id = id;
        return self();
    }

    public B withVendor(String vendor) {
        this.vendor = vendor;
        return self();
    }

    public B withModel(String model) {
        this.model = model;
        return self();
    }

    public B withYear(int year) {
        this.year = year;
        return self();
    }

    public B withColor(Color color) {
        this.color = color;
        return self();
    }

    public B withMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
        return self();
    }

    public B withFuelConsumption(int liters) {
        this.fuelConsumption = liters;
        return self();
    }

    public B withValue(int value) {
        this.value = value;
        return self();
    }

    public abstract Car build();

    final B self() {
        return (B) this;
    }

    public long getId() {
        return id;
    }

    public String getVendor() {
        return vendor;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public Color getColor() {
        return color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public int getValue() {
        return value;
    }
}
