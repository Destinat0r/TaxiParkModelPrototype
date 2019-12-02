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
        print(resourceManager.getString(StringConstants.TOTAL_VALUE));
        print("" + value);
    }

    public void print(String string) {
        System.out.println(string);
    }

    public void printWelcome() {
        print(resourceManager.getString(StringConstants.WELCOME));
    }

    public void printSortedByFuelConsumptionAsc(List<Car> cars) {
        print(resourceManager.getString(StringConstants.SORT_BY_FUEL_CONSUMPTION_ASC));
        printAllCars(cars);
    }

    public void printCarsWithinSpeedRange(int min, int max, List<Car> cars) {
        String message = resourceManager.getString(StringConstants.WITHIN_MAX_SPEED_RANGE);
        System.out.printf(message, min, max);
        printAllCars(cars);
    }
}
