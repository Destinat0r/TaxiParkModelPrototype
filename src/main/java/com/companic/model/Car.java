package com.companic.model;

import java.time.Year;

public class Car {

    private long id;
    private String vendor;
    private String model;
    private Type type;
    private int year;
    private Color color;
    private int maxSpeed;
    private int fuelConsumption;
    private int value;

    public Car(CarBuilder builder) {

        allFieldsSetCheck(builder);
        this.vendor = builder.getVendor();
        this.model = builder.getModel();
        this.type = builder.getType();
        this.year = builder.getYear();
        this.color = builder.getColor();
        this.maxSpeed = builder.getMaxSpeed();
        this.fuelConsumption = builder.getFuelConsumption();
        this.value = builder.getValue();
    }

    private void allFieldsSetCheck(CarBuilder builder) {
        if (builder.getVendor() == null) {
            throw new IllegalArgumentException("vendor is not set");
        }
        if (builder.getModel() == null) {
            throw new IllegalArgumentException("model is not set");
        }
        if (builder.getType() == null) {
            throw new IllegalArgumentException("type is not set");
        }
        if (builder.getYear() <= 1970 || builder.getYear() > Year.now().getValue()) {
            throw new IllegalArgumentException("year is not set or invalid");
        }
        if (builder.getMaxSpeed() <= 60 || builder.getMaxSpeed() >= 400) {
            throw new IllegalArgumentException("maxSpeed is not set or invalid");
        }
        if (builder.getFuelConsumption() <= 0) {
            throw new IllegalArgumentException("fuelConsumption is not set or invalid");
        }
        if (builder.getValue() <= 0) {
            throw new IllegalArgumentException("value is not set or invalid");
        }
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override public String toString() {
        return "Car{" + "id=" + id + ", vendor='" + vendor + '\'' + ", model='" + model + '\'' + ", type=" + type
                       + ", year=" + year + ", color=" + color + ", maxSpeed=" + maxSpeed + ", fuelConsumption="
                       + fuelConsumption + ", value=" + value + '}';
    }
}
