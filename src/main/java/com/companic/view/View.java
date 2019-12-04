package com.companic.view;

import com.companic.model.entity.Car;
import com.companic.model.entity.PassengerCar;
import com.companic.model.entity.Truck;
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
        print(getFromResources(LocaleConstants.TOTAL_VALUE));
        print("" + value);
    }

    public void print(String string) {
        System.out.println(string);
    }

    public void printWelcome() {
        print(getFromResources(LocaleConstants.WELCOME));
    }

    public void printSortedByFuelConsumptionAsc(List<Car> cars) {
        print(getFromResources(LocaleConstants.SORT_BY_FUEL_CONSUMPTION_ASC));
        printAllCars(cars);
    }

    public void printCarsWithinSpeedRange(int min, int max, List<Car> cars) {
        String message = getFromResources(LocaleConstants.WITHIN_MAX_SPEED_RANGE);
        System.out.printf(message, min, max);
        printAllCars(cars);
    }

    public void printCar(Car car) {
        StringBuilder builder = new StringBuilder(200);
        String colon = ": ";
        String divider = ", ";

        boolean isPassenger = Car.class.getClass().equals("PassengerCar");


        builder.append(getFromResources(LocaleConstants.CAR)).append(" [ ").append(getFromResources(LocaleConstants.ID))
                .append(colon).append(car.getId()).append(divider).append(getFromResources(LocaleConstants.VENDOR))
                .append(colon).append(car.getVendor()).append(divider).append(getFromResources(LocaleConstants.MODEL))
                .append(colon).append(car.getModel()).append(divider);

        if (isPassenger) {
            PassengerCar passengerCar = (PassengerCar) car;
            builder.append(getFromResources(LocaleConstants.BODY)).append(colon).append(passengerCar.getBody())
                    .append(divider);
        } else {
            Truck truck = (Truck) car;
            builder.append(getFromResources(LocaleConstants.DUTY)).append(colon).append(truck.getDuty()).append(divider)
                    .append(getFromResources(LocaleConstants.PAYLOAD)).append(colon).append(truck.getPayload())
                    .append(divider);
        }

        builder.append(getFromResources(LocaleConstants.YEAR)).append(colon).append(car.getYear()).append(divider)
                .append(getFromResources(LocaleConstants.COLOR)).append(colon).append(car.getColor()).append(divider)
                .append(getFromResources(LocaleConstants.MAX_SPEED)).append(colon).append(car.getMaxSpeed()).append(divider)
                .append(getFromResources(LocaleConstants.FUEL)).append(colon).append(car.getFuelConsumption()).append(divider)
                .append(getFromResources(LocaleConstants.VALUE)).append(colon).append(car.getValue()).append(" ]");

        print(builder.toString());
    }

    private String getFromResources(String prop) {
        return resourceManager.getString(prop);
    }
}
