package com.companic.model.entity.car;

import com.companic.model.entity.VehicleBuilder;

public class CarBuilder extends VehicleBuilder<CarBuilder> {

    private Body body;
    private int passengersAmount;

    public static CarBuilder passengerCar() {
        return new CarBuilder();
    }

    public CarBuilder withBody(Body body) {
        this.body = body;
        return this;
    }

    public CarBuilder withPassengersAmount(int amount) {
        this.passengersAmount = amount;
        return this;
    }

    public Car build() {
        return new Car(this);
    }

    public Body getBody() {
        return body;
    }

    public int getPassengersAmount() {
        return passengersAmount;
    }
}
