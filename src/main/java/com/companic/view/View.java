package com.companic.view;

import com.companic.model.entity.car.Car;
import com.companic.model.entity.Vehicle;
import com.companic.model.entity.truck.Truck;
import com.companic.utils.LocaleConstants;
import com.companic.utils.ResourceManager;

import java.util.List;
import java.util.stream.IntStream;

public class View {

    private ResourceManager resourceManager;

    public View() {
        this.resourceManager = ResourceManager.INSTANCE;
    }

    public void printInitialProgramInfo(List<Vehicle> vehicles) {
        printWelcome();
        print("");
        print(resourceManager.getLocaleProperty(LocaleConstants.SHOW_ALL_CARS));
        print("");
        printCars(vehicles);
    }

    public void printCars(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            printCar(vehicle);
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

    public void printSortedByFuelConsumptionAsc(List<Vehicle> vehicles) {
        print(getFromResources(LocaleConstants.SORT_BY_FUEL_CONSUMPTION_ASC));
        print("");
        printCars(vehicles);
    }

    public void printCarsWithinSpeedRange(int min, int max, List<Vehicle> vehicles) {
        System.out.printf(getFromResources(LocaleConstants.WITHIN_MAX_SPEED_RANGE), min, max);
        print("\n");
        printCars(vehicles);
    }

    public void printCar(Vehicle vehicle) {
        print(generateInfoOutputFor(vehicle));
    }

    private String generateInfoOutputFor(Vehicle vehicle) {
        StringBuilder builder = new StringBuilder(200);

        String keyValueDivider = getFromResources(LocaleConstants.KEY_VALUE_DIVIDER);
        String divider = getFromResources(LocaleConstants.DIVIDER);

        appendCorrectCarType(vehicle, builder);

        builder.append(getFromResources(LocaleConstants.LEFT_BORDER))
                .append(getFromResources(LocaleConstants.LICENSE_PLATE)).append(keyValueDivider)
                .append(vehicle.getLicensePlate()).append(divider).append(getFromResources(LocaleConstants.VENDOR))
                .append(keyValueDivider).append(vehicle.getVendor()).append(divider)
                .append(getFromResources(LocaleConstants.MODEL)).append(keyValueDivider).append(vehicle.getModel())
                .append(divider);

        appendSpecificInfo(vehicle, builder);

        builder.append(getFromResources(LocaleConstants.YEAR)).append(keyValueDivider).append(vehicle.getYear())
                .append(divider).append(getFromResources(LocaleConstants.COLOR)).append(keyValueDivider)
                .append(getFromResources(getColorResourceName(vehicle))).append(divider)
                .append(getFromResources(LocaleConstants.MAX_SPEED)).append(keyValueDivider).append(vehicle.getMaxSpeed())
                .append(divider).append(getFromResources(LocaleConstants.FUEL)).append(keyValueDivider)
                .append(vehicle.getFuelConsumption()).append(divider).append(getFromResources(LocaleConstants.VALUE))
                .append(keyValueDivider).append(vehicle.getValue())
                .append(getFromResources(LocaleConstants.RIGHT_BORDER));

        return builder.toString();
    }

    private String getColorResourceName(Vehicle vehicle) {
        return new StringBuilder(LocaleConstants.COLOR).append(".")
                       .append(vehicle.getColor().toString().toLowerCase()).toString();
    }

    private void appendSpecificInfo(Vehicle vehicle, StringBuilder builder) {
        String keyValueDivider = getFromResources(LocaleConstants.KEY_VALUE_DIVIDER);
        String divider = getFromResources(LocaleConstants.DIVIDER);

        if (vehicle instanceof Car) {
            Car passengerCar = (Car) vehicle;
            builder.append(getFromResources(LocaleConstants.BODY)).append(keyValueDivider)
                    .append(getFromResources(getBodyTypeName(passengerCar))).append(divider)
                    .append(getFromResources(LocaleConstants.PASSENGERS_AMOUNT)).append(keyValueDivider)
                    .append(passengerCar.getPassengersAmount()).append(divider);
        } else if (vehicle instanceof Truck) {
            Truck truck = (Truck) vehicle;
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

    private String getBodyTypeName(Car passengerCar) {
        return new StringBuilder(LocaleConstants.BODY).append(".")
                       .append(passengerCar.getBody().toString().toLowerCase()).toString();
    }

    private void appendCorrectCarType(Vehicle vehicle, StringBuilder builder) {
        if (vehicle instanceof Car) {
            builder.append(getFromResources(LocaleConstants.PASSENGER_CAR));
        } else if (vehicle instanceof Truck){
            builder.append(getFromResources(LocaleConstants.TRUCK));
        }
    }

    private String getFromResources(String prop) {
        return resourceManager.getLocaleProperty(prop);
    }
}
