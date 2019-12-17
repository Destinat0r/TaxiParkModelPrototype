package com.companic.model;

import com.companic.model.entity.AbstractVehicle;
import com.companic.model.entity.Vehicle;

import java.util.*;
import java.util.stream.Collectors;

public class TaxiParkImpl implements TaxiPark {

    private List<Vehicle> vehicles;

    public TaxiParkImpl() {
        this.vehicles = new ArrayList<>();
    }

    public TaxiParkImpl(Vehicle[] ... vehicles) {
        this.vehicles = new ArrayList<>();
        for (Vehicle[] vehicleArray : vehicles) {
            this.vehicles.addAll(Arrays.asList(vehicleArray));
        }
    }

    public int calculateTotalValue() {
        return vehicles.stream().mapToInt(car -> car.getValue()).sum();
    }

    public List<Vehicle> sortByFuelConsumptionAsc() {
        List<Vehicle> sorted = new ArrayList<>(vehicles);
        sorted.sort(Comparator.comparingInt(Vehicle::getFuelConsumption));
        return sorted;
    }

    public List<Vehicle> findCarsWithinGivenMaxSpeedRange(int min, int max) {
        return vehicles.stream()
                       .filter(x -> x.getMaxSpeed() >= min && x.getMaxSpeed() <= max)
                       .collect(Collectors.toList());
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
