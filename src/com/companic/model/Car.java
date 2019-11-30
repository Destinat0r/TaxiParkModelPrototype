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

        allFieldsSetCheck(builder);
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
        if (builder.getYear() == 0) {
            throw new IllegalArgumentException("year is not set");
        }
        if (builder.getMaxSpeed() == 0) {
            throw new IllegalArgumentException("maxSpeed is not set");
        }
        if (builder.getFuelConsumption() == 0) {
            throw new IllegalArgumentException("fuelConsumption is not set");
        }
        if (builder.getAccelerationTime() == 0) {
            throw new IllegalArgumentException("accelerationTime is not set");
        }
        if (builder.getValue() == 0) {
            throw new IllegalArgumentException("value is not set");
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

    @Override public String toString() {
        return "Car{" + "id=" + id + ", vendor='" + vendor + '\'' + ", model='" + model + '\'' + ", type=" + type
                       + ", year=" + year + ", color=" + color + ", maxSpeed=" + maxSpeed + ", fuelConsumption="
                       + fuelConsumption + ", accelerationTime=" + accelerationTime + ", value=" + value + '}';
    }
}
