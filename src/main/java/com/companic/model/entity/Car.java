package com.companic.model.entity;

import com.companic.utils.ConfigConstants;
import com.companic.utils.ResourceManager;

import java.time.Year;
import java.util.Objects;

/**
 * Represents blueprint of generic car.
 * Uses <b>Builder</b> design pattern in constructor.
 */
public abstract class Car {
    private String licensePlate;
    private String vendor;
    private String model;
    private int year;
    private Color color;
    private int maxSpeed;
    /**
     * Fuel consumption in liters per 100 km
     */
    private int fuelConsumption;
    private int value;

    public Car(CarBuilder builder) {
        checkFields(builder);
        this.licensePlate = builder.getLicensePlate();
        this.vendor = builder.getVendor();
        this.model = builder.getModel();
        this.year = builder.getYear();
        this.color = builder.getColor();
        this.maxSpeed = builder.getMaxSpeed();
        this.fuelConsumption = builder.getFuelConsumption();
        this.value = builder.getValue();
    }

    private void checkFields(CarBuilder builder) {
        String licensePlate = builder.getLicensePlate();
        
        if (licensePlate == null || !isValidLicensePlate(licensePlate)) {
            throw new IllegalArgumentException("license plate is not set or invalid");
        }
        if (builder.getVendor() == null) {
            throw new IllegalArgumentException("vendor is not set");
        }
        if (builder.getModel() == null) {
            throw new IllegalArgumentException("model is not set");
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

    private boolean isValidLicensePlate(String licensePlate) {
        return licensePlate.matches(ResourceManager.INSTANCE.getConfigProperty(ConfigConstants.REGEX_LICENSE_PLATE));
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
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

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Car car = (Car) o;
        return year == car.year && maxSpeed == car.maxSpeed && fuelConsumption == car.fuelConsumption
                       && value == car.value && Objects.equals(licensePlate, car.licensePlate) && Objects.equals(vendor,
                car.vendor) && Objects.equals(model, car.model) && color == car.color;
    }

    @Override public int hashCode() {
        return Objects.hash(licensePlate, vendor, model, year, color, maxSpeed, fuelConsumption, value);
    }
}
