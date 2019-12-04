package com.companic.view;

import com.companic.model.entity.Car;
import com.companic.model.entity.PassengerCar;
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
        StringBuilder builder = new StringBuilder(200);
        String colon = ": ";
        String divider = ", ";
        builder.append(getFromResources(Constants.CAR))
                .append(" [ ").append(getFromResources(Constants.ID)).append(colon).append(car.getId()).append(divider)
                .append(getFromResources(Constants.VENDOR)).append(colon).append(car.getVendor()).append(divider)
                .append(getFromResources(Constants.MODEL)).append(colon).append(car.getModel()).append(divider)
                //.append(getFromResources(Constants.BODY)).append(colon).append(car.getBody()).append(divider)
                .append(getFromResources(Constants.YEAR)).append(colon).append(car.getYear()).append(divider)
                .append(getFromResources(Constants.COLOR)).append(colon).append(car.getColor()).append(divider)
                .append(getFromResources(Constants.MAX_SPEED)).append(colon).append(car.getMaxSpeed()).append(divider)
                .append(getFromResources(Constants.FUEL)).append(colon).append(car.getFuelConsumption()).append(divider)
                .append(getFromResources(Constants.VALUE)).append(colon).append(car.getValue()).append(" ]");

        print(builder.toString());
    }

    private String getFromResources(String prop) {
        return resourceManager.getString(prop);
    }
}
