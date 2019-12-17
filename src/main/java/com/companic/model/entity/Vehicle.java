package com.companic.model.entity;

public interface Vehicle {
    int getFuelConsumption();

    String getLicensePlate();

    void setLicensePlate(String licensePlate);

    String getVendor();

    void setVendor(String vendor);

    String getModel();

    void setModel(String model);

    int getYear();

    void setYear(int year);

    Color getColor();

    void setColor(Color color);

    int getMaxSpeed();

    void setMaxSpeed(int maxSpeed);

    void setFuelConsumption(int fuelConsumption);

    int getValue();

    void setValue(int value);

}
