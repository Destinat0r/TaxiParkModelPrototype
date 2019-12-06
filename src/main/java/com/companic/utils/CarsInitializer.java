package com.companic.utils;

import com.companic.model.entity.PassengerCar;
import com.companic.model.entity.Truck;

public class CarsInitializer {

    private static final ResourceManager RESOURCE_MANAGER = ResourceManager.INSTANCE;

    public static PassengerCar[] initPassengerCarsFromJsonFile() {
        return JsonLoader.loadFromJson(RESOURCE_MANAGER.getConfigProperty(ConfigConstants.PATH_JSON_PASSENGER_CARS), PassengerCar[].class);
    }

    public static Truck[] initTrucksFromJsonFile() {
        return JsonLoader.loadFromJson(RESOURCE_MANAGER.getConfigProperty(ConfigConstants.PATH_JSON_TRUCKS), Truck[].class);
    }
}
