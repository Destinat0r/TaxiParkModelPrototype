package com.companic.model.entities;

import com.companic.model.Body;

public class PassengerCar extends Car {

    private Body body;
    private int passengersAmount;

    public PassengerCar(PassengerCarBuilder builder) {
        super(builder);
        checkFields(builder);
        this.body = builder.getBody();
        this.passengersAmount = builder.getPassengersAmount();
    }

    private void checkFields(PassengerCarBuilder builder) {
        if (builder.getBody() == null) {
            throw new IllegalArgumentException("body is not set");
        }
        if (builder.getPassengersAmount() <= 0) {
            throw new IllegalArgumentException("passengersAmount is not set or invalid");
        }
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public int getPassengersAmount() {
        return passengersAmount;
    }

    public void setPassengersAmount(int passengersAmount) {
        this.passengersAmount = passengersAmount;
    }
}
