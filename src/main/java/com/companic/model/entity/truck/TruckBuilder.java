package com.companic.model.entity.truck;

import com.companic.model.entity.VehicleBuilder;

public class TruckBuilder extends VehicleBuilder<TruckBuilder> {

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
