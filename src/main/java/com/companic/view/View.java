package com.companic.view;

import com.companic.model.entity.Car;
import com.companic.model.entity.PassengerCar;
import com.companic.model.entity.Truck;
import com.companic.utils.LocaleConstants;
import com.companic.utils.ResourceManager;

import java.util.List;

public class View {

    private ResourceManager resourceManager;

    public View() {
        this.resourceManager = ResourceManager.INSTANCE;
    }

    public void printInitialProgramInfo(List<Car> cars) {
        printWelcome();
        print("");
        print(resourceManager.getLocaleProperty(LocaleConstants.VIEW_ALL));
        print("");
        printCars(cars);
    }

    public void printCars(List<Car> cars) {
        for (Car car : cars) {
            printCar(car);
            print("");
        }
        printLineDivider();
    }

    private void printLineDivider() {
        String lineDividerSymbol = resourceManager.getLocaleProperty(LocaleConstants.LINE_DIVIDER_SYMBOL);
        for (int i = 0; i++ < 300;) {
            System.out.print(lineDividerSymbol);
        }
        print("\n");
    }

    public void printTotalValue(int value) {
        print(getFromResources(LocaleConstants.TOTAL_VALUE));
        print("" + value);
        printLineDivider();
    }

    public void print(String string) {
        System.out.println(string);
    }

    public void printWelcome() {
        print(getFromResources(LocaleConstants.WELCOME));
    }

    public void printSortedByFuelConsumptionAsc(List<Car> cars) {
        print(getFromResources(LocaleConstants.SORT_BY_FUEL_CONSUMPTION_ASC));
        print("");
        printCars(cars);
    }

    public void printCarsWithinSpeedRange(int min, int max, List<Car> cars) {
        System.out.printf(getFromResources(LocaleConstants.WITHIN_MAX_SPEED_RANGE), min, max);
        printCars(cars);
    }

    public void printCar(Car car) {
        print(generateInfoOutputFor(car));
    }

    private String generateInfoOutputFor(Car car) {
        StringBuilder builder = new StringBuilder(200);

        String keyValueDivider = getFromResources(LocaleConstants.KEY_VALUE_DIVIDER);
        String divider = getFromResources(LocaleConstants.DIVIDER);

        appendCorrectCarType(car, builder);

        builder.append(getFromResources(LocaleConstants.LEFT_BORDER))
                .append(getFromResources(LocaleConstants.LICENSE_PLATE)).append(keyValueDivider)
                .append(car.getLicensePlate()).append(divider).append(getFromResources(LocaleConstants.VENDOR))
                .append(keyValueDivider).append(car.getVendor()).append(divider)
                .append(getFromResources(LocaleConstants.MODEL)).append(keyValueDivider).append(car.getModel())
                .append(divider);

        appendSpecificInfo(car, builder);

        builder.append(getFromResources(LocaleConstants.YEAR)).append(keyValueDivider).append(car.getYear())
                .append(divider).append(getFromResources(LocaleConstants.COLOR)).append(keyValueDivider)
                .append(getFromResources(getColorResourceName(car))).append(divider)
                .append(getFromResources(LocaleConstants.MAX_SPEED)).append(keyValueDivider).append(car.getMaxSpeed())
                .append(divider).append(getFromResources(LocaleConstants.FUEL)).append(keyValueDivider)
                .append(car.getFuelConsumption()).append(divider).append(getFromResources(LocaleConstants.VALUE))
                .append(keyValueDivider).append(car.getValue())
                .append(getFromResources(LocaleConstants.RIGHT_BORDER));

        return builder.toString();
    }

    private String getColorResourceName(Car car) {
        return new StringBuilder(LocaleConstants.COLOR).append(".")
                       .append(car.getColor().toString().toLowerCase()).toString();
    }

    private void appendSpecificInfo(Car car, StringBuilder builder) {
        String keyValueDivider = getFromResources(LocaleConstants.KEY_VALUE_DIVIDER);
        String divider = getFromResources(LocaleConstants.DIVIDER);

        if (car instanceof PassengerCar) {
            PassengerCar passengerCar = (PassengerCar) car;
            builder.append(getFromResources(LocaleConstants.BODY)).append(keyValueDivider)
                    .append(getFromResources(getBodyTypeName(passengerCar))).append(divider)
                    .append(getFromResources(LocaleConstants.PASSENGERS_AMOUNT)).append(keyValueDivider)
                    .append(passengerCar.getPassengersAmount()).append(divider);
        } else if (car instanceof Truck) {
            Truck truck = (Truck) car;
            builder.append(getFromResources(LocaleConstants.DUTY)).append(keyValueDivider)
                    .append(getFromResources(getDutyTypeName(truck))).append(divider)
                    .append(getFromResources(LocaleConstants.PAYLOAD)).append(keyValueDivider)
                    .append(truck.getPayload()).append(divider);
        }
    }

    private String getDutyTypeName(Truck truck) {
        return new StringBuilder(LocaleConstants.DUTY)
                       .append(".").append(truck.getDuty().toString().toLowerCase()).toString();
    }

    private String getBodyTypeName(PassengerCar passengerCar) {
        return new StringBuilder(LocaleConstants.BODY).append(".")
                       .append(passengerCar.getBody().toString().toLowerCase()).toString();
    }

    private void appendCorrectCarType(Car car, StringBuilder builder) {
        if (car instanceof PassengerCar) {
            builder.append(getFromResources(LocaleConstants.PASSENGER_CAR));
        } else if (car instanceof Truck){
            builder.append(getFromResources(LocaleConstants.TRUCK));
        }
    }

    private String getFromResources(String prop) {
        return resourceManager.getLocaleProperty(prop);
    }
}
