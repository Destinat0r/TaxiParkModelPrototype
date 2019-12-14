package com.companic.utils;

import com.companic.model.entity.PassengerVehicle;
import com.companic.model.entity.Truck;

public class CarsInitializer {

    private static final ResourceManager RESOURCE_MANAGER = ResourceManager.INSTANCE;

    public static PassengerVehicle[] initPassengerCarsFromJsonFile() {
        return JsonArrayLoader
                       .readFromJson(RESOURCE_MANAGER.getConfigProperty(ConfigConstants.PATH_JSON_PASSENGER_CARS),
                               PassengerVehicle[].class);
    }

    public static Truck[] initTrucksFromJsonFile() {
        return JsonArrayLoader.readFromJson(RESOURCE_MANAGER.getConfigProperty(ConfigConstants.PATH_JSON_TRUCKS),
                Truck[].class);
    }
}
