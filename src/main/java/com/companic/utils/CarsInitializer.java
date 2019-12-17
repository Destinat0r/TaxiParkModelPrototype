package com.companic.utils;

import com.companic.model.entity.car.Car;
import com.companic.model.entity.truck.Truck;

public class CarsInitializer {

    private static final ResourceManager RESOURCE_MANAGER = ResourceManager.INSTANCE;

    public static Car[] initPassengerCarsFromJsonFile() {
        return JsonArrayLoader
                       .readFromJson(RESOURCE_MANAGER.getConfigProperty(ConfigConstants.PATH_JSON_CARS),
                               Car[].class);
    }

    public static Truck[] initTrucksFromJsonFile() {
        return JsonArrayLoader.readFromJson(RESOURCE_MANAGER.getConfigProperty(ConfigConstants.PATH_JSON_TRUCKS),
                Truck[].class);
    }
}
