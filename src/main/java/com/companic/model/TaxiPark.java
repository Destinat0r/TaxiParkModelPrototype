package com.companic.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

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

    public ArrayList<Car> sortByFuelConsumption() {
        ArrayList<Car> sorted = new ArrayList<>();
        Collections.copy(sorted, cars);

        Collections.sort(sorted, Comparator.comparingInt(Car::getFuelConsumption));

        return sorted;
    }
}
