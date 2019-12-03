package com.companic.model.entity;

public class Truck extends Car {
    private Duty duty;
    private int payload;

    public Truck(TruckBuilder builder) {
        super(builder);
        checkFields(builder);
        this.duty = builder.getDuty();
        this.payload = builder.getPayload();
    }

    private void checkFields(TruckBuilder builder) {
        if (builder.getDuty() == null) {
            throw new IllegalArgumentException("duty is not set");
        }
        if (builder.getPayload() <= 0) {
            throw new IllegalArgumentException("payload isn't set or invalid");
        }
    }

    public Duty getDuty() {
        return duty;
    }

    public void setDuty(Duty duty) {
        this.duty = duty;
    }

    public int getPayload() {
        return payload;
    }

    public void setPayload(int payload) {
        this.payload = payload;
    }
}
