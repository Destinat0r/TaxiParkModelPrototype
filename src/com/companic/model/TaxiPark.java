package com.companic.model;

import java.util.ArrayList;

public class TaxiPark {
    private ArrayList<Car> cars;

    public TaxiPark(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public int calculateTotalValue() {
        int totalValue = 0;

        for (Car car : cars) {
            totalValue += car.getValue();
        }
        return totalValue;
    }

}
