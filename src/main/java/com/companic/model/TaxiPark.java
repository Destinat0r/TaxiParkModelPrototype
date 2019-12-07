package com.companic.model;

import com.companic.model.entity.Car;

import java.util.*;
import java.util.stream.Collectors;

public class TaxiPark {

    private List<Car> cars;

    public TaxiPark() {
        this.cars = new ArrayList<>();
    }

    public TaxiPark(Car[] ...cars) {
        if (cars == null) { //
            throw new IllegalArgumentException("cars in null");
        }
        this.cars = new ArrayList<>();
        for (Car[] carArray : cars) {
            this.cars.addAll(Arrays.asList(carArray));
        }
    }

    public int calculateTotalValue() {
        int totalValue = 0;

        for (Car car : cars) {
            totalValue += car.getValue();
        }
        return totalValue;
    }

    public List<Car> sortByFuelConsumptionAsc() {
        List<Car> sorted = new ArrayList<>(cars);
        Collections.sort(sorted, Comparator.comparingInt(Car::getFuelConsumption)); //could be list
        return sorted;
    }

    public List<Car> findCarsWithinGivenMaxSpeedRange(int min, int max) {
        return cars.stream()
                       .filter(x -> x.getMaxSpeed() >= min && x.getMaxSpeed() <= max)
                       .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }
}
