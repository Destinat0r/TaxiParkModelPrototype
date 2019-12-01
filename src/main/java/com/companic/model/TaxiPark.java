package com.companic.model;

import java.util.ArrayList;
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

    public ArrayList<Car> sortByFuelConsumptionAsc() {
        ArrayList<Car> sorted = new ArrayList<>(cars);

        Collections.sort(sorted, Comparator.comparingInt(Car::getFuelConsumption));

        return sorted;
    }

    public ArrayList<Car> findCarsWithinGivenMaxSpeedRange(int min, int max) {
        ArrayList<Car> foundCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getMaxSpeed() >= min && car.getMaxSpeed() <= max) {
                foundCars.add(car);
            }
        }
        return foundCars;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }
}
