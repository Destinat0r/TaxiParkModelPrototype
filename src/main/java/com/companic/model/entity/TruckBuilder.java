package com.companic.model.entity;

public class TruckBuilder extends CarBuilder<TruckBuilder> {
    private Duty duty;
    private int payload;

    public static TruckBuilder truck() {
        return new TruckBuilder();
    }

    public TruckBuilder withDuty(Duty duty) {
        this.duty = duty;
        return this;
    }

    public TruckBuilder withPayload(int payload) {
        this.payload = payload;
        return this;
    }

    public Truck build() {
        return new Truck(this);
    }

    public Duty getDuty() {
        return duty;
    }

    public int getPayload() {
        return payload;
    }
}
