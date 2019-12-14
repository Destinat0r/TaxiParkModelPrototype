package com.companic.model;

import com.companic.model.entity.AbstractVehicle;

import java.util.List;

public interface TaxiPark {
    int calculateTotalValue();
    List<AbstractVehicle> sortByFuelConsumptionAsc();
    List<AbstractVehicle> findCarsWithinGivenMaxSpeedRange(int min, int max);
    List<AbstractVehicle> getVehicles();
}
