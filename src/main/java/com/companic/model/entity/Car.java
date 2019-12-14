package com.companic.model.entity;

import java.util.Objects;

public class Car extends Vehicle {

    private Body body;
    private int passengersAmount;

    public Car(PassengerCarBuilder builder) {
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

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        Car that = (Car) o;
        return passengersAmount == that.passengersAmount && body == that.body;
    }

    @Override public int hashCode() {
        return Objects.hash(super.hashCode(), body, passengersAmount);
    }
}
