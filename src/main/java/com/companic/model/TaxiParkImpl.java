package com.companic.model;

import com.companic.model.entity.AbstractVehicle;

import java.util.*;
import java.util.stream.Collectors;

public class TaxiParkImpl implements TaxiPark {

    private List<AbstractVehicle> vehicles;

    public TaxiParkImpl() {
        this.vehicles = new ArrayList<>();
    }

    public TaxiParkImpl(AbstractVehicle[] ... vehicles) {
        this.vehicles = new ArrayList<>();
        for (AbstractVehicle[] vehicleArray : vehicles) {
            this.vehicles.addAll(Arrays.asList(vehicleArray));
        }
    }

    public int calculateTotalValue() {
        return vehicles.stream().mapToInt(car -> car.getValue()).sum();
    }

    public List<AbstractVehicle> sortByFuelConsumptionAsc() {
        List<AbstractVehicle> sorted = new ArrayList<>(vehicles);
        sorted.sort(Comparator.comparingInt(AbstractVehicle::getFuelConsumption));
        return sorted;
    }

    public List<AbstractVehicle> findCarsWithinGivenMaxSpeedRange(int min, int max) {
        return vehicles.stream()
                       .filter(x -> x.getMaxSpeed() >= min && x.getMaxSpeed() <= max)
                       .collect(Collectors.toList());
    }

    public List<AbstractVehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<AbstractVehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
