package com.companic.view;

import com.companic.model.Car;
import com.companic.util.ResourceManager;

import java.util.List;

public class View {

    private ResourceManager resourceManager;

    public View() {
        this.resourceManager = ResourceManager.INSTANCE;
    }

    public void printAllCars(List<Car> cars) {
        for (Car car : cars) {
            print(car.toString());
        }
    }

    public void printTotalValue(int value) {
        print(resourceManager.getString("total_value"));
        print("" + value);
    }

    public void print(String string) {
        System.out.println(string);
    }

    public void printWelcome() {
        print(resourceManager.getString("welcome"));
    }

    public void printSortedByFuelConsumptionAsc(List<Car> cars) {
        print(resourceManager.getString("sort_by_fuel_consumption_asc"));
        printAllCars(cars);
    }

    public void printCarsWithinSpeedRange(int min, int max, List<Car> cars) {
        String message = resourceManager.getString("within_max_speed_range");
        System.out.printf(message, min, max);
        printAllCars(cars);
    }
}
