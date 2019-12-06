package com.companic.controller;

import com.companic.model.TaxiPark;
import com.companic.model.entity.PassengerCar;
import com.companic.model.entity.Truck;
import com.companic.utils.CarsInitializer;
import com.companic.utils.ConfigConstants;
import com.companic.utils.ResourceManager;
import com.companic.view.View;

import java.util.Locale;

public class Controller {

    private View view;
    private ResourceManager resourceManager = ResourceManager.INSTANCE;

    public Controller(View view) {
        this.view = view;
    }

    public void run() {
        resourceManager.changeLocale(new Locale(resourceManager.getParameter(ConfigConstants.LOCALE_CURRENT)));

        Truck[] trucks = CarsInitializer.initTrucksFromJsonFile();
        PassengerCar[] cars = CarsInitializer.initPassengerCarsFromJsonFile();

        TaxiPark taxiPark = new TaxiPark(cars, trucks);

        view.printWelcome();
        view.print("");
        view.printAllCars(taxiPark.getCars());
        view.print("");
        view.printSortedByFuelConsumptionAsc(taxiPark.sortByFuelConsumptionAsc());
        view.print("");
        view.printTotalValue(taxiPark.calculateTotalValue());
        view.print("");
        view.printCarsWithinSpeedRange(130, 260, taxiPark.findCarsWithinGivenMaxSpeedRange(130, 260));
    }

}