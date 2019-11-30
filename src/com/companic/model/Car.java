package com.companic.model;

public class Car {

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

    public Car(CarBuilder builder) {
        if (vendor == null || model == null || type == null || year == 0 || maxSpeed == 0 || fuelConsumption == 0
                || accelerationTime == 0 || value == 0) {
            throw new IllegalArgumentException();
        }
        this.vendor = builder.getVendor();
        this.model = builder.getModel();
        this.type = builder.getType();
        this.year = builder.getYear();
        this.color = builder.getColor();
        this.maxSpeed = builder.getMaxSpeed();
        this.fuelConsumption = builder.getFuelConsumption();
        this.accelerationTime = builder.getAccelerationTime();
        this.value = builder.getValue();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int getAccelerationTime() {
        return accelerationTime;
    }

    public void setAccelerationTime(int accelerationTime) {
        this.accelerationTime = accelerationTime;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
