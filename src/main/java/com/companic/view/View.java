package com.companic.view;

import com.companic.model.entity.Car;
import com.companic.util.ResourceManager;

import java.util.List;

public class View {

    private ResourceManager resourceManager;

    public View() {
        this.resourceManager = ResourceManager.INSTANCE;
    }

    public void printAllCars(List<Car> cars) {
        for (Car car : cars) {
            emulateLoading(300);
            printCar(car);
        }
    }

    private void emulateLoading(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {

        }
    }

    public void printTotalValue(int value) {
        print(getFromResources(Constants.TOTAL_VALUE));
        print("" + value);
    }

    public void print(String string) {
        System.out.println(string);
    }

    public void printWelcome() {
        print(getFromResources(Constants.WELCOME));
    }

    public void printSortedByFuelConsumptionAsc(List<Car> cars) {
        print(getFromResources(Constants.SORT_BY_FUEL_CONSUMPTION_ASC));
        printAllCars(cars);
    }

    public void printCarsWithinSpeedRange(int min, int max, List<Car> cars) {
        String message = getFromResources(Constants.WITHIN_MAX_SPEED_RANGE);
        System.out.printf(message, min, max);
        printAllCars(cars);
    }

    public void printCar(Car car) {
        print(getFromResources(Constants.CAR) + " [ " + getFromResources(Constants.ID) + ": " + car.getId() + ", "
                       + getFromResources(Constants.VENDOR)  + ": " + car.getVendor() +  ", "
                       + getFromResources(Constants.MODEL) + ": " + car.getModel() + ", " + getFromResources(Constants.TYPE) + ": "
                       + ", " + getFromResources(Constants.YEAR) + ": " + car.getYear() + ", "+ getFromResources(Constants.COLOR)
                       + ": " + car.getColor() + ", " + getFromResources(Constants.MAX_SPEED) + ": " + car.getMaxSpeed() + ", "
                       + getFromResources(Constants.FUEL) + ": " + car.getFuelConsumption() + ", " + getFromResources(Constants.VALUE)
                       + ": " + car.getValue() + " ]");

    }

    private String getFromResources(String prop) {
        return resourceManager.getString(prop);
    }
}
