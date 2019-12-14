package com.companic.model;

import com.companic.model.entity.Vehicle;

import java.util.List;

public interface TaxiPark {
    int calculateTotalValue();
    List<Vehicle> sortByFuelConsumptionAsc();
    List<Vehicle> findCarsWithinGivenMaxSpeedRange(int min, int max);
}
