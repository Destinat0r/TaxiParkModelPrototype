package com.companic.model;

public class CarBuilder {
    private long id;
    private String vendor;
    private String model;
    private Type type;
    private int year;
    private Color color;
    private int maxSpeed;
    private int fuelConsumption;
    private int accelerationTime;
    private int value;

    public static CarBuilder car() {
        return new CarBuilder();
    }

    public CarBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public CarBuilder withVendor(String vendor) {
        this.vendor = vendor;
        return this;
    }

    public CarBuilder withModel(String model) {
        this.model = model;
        return this;
    }

    public CarBuilder withType(Type type) {
        this.type = type;
        return this;
    }

    public CarBuilder withYear(int year) {
        this.year = year;
        return this;
    }

    public CarBuilder withColor(Color color) {
        this.color = color;
        return this;
    }

    public CarBuilder withMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
        return this;
    }

    public CarBuilder withFuelConsumption(int liters) {
        this.fuelConsumption = liters;
        return this;
    }

    public CarBuilder withAccelerationTime(int accelerationTime) {
        this.accelerationTime = accelerationTime;
        return this;
    }

    public CarBuilder withValue(int value) {
        this.value = value;
        return this;
    }

    public Car build() {
        return new Car(this);
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

    public Type getType() {
        return type;
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

    public int getAccelerationTime() {
        return accelerationTime;
    }

    public int getValue() {
        return value;
    }
}
