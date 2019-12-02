package com.companic.controller;

import com.companic.model.Color;
import com.companic.model.Type;
import com.companic.model.entity.Car;
import com.companic.model.entity.TaxiPark;
import com.companic.util.ResourceManager;
import com.companic.view.View;

import java.util.Locale;

import static com.companic.model.CarBuilder.car;

public class Controller {

    private View view;

    public Controller(View view) {
        this.view = view;
    }

    public void run() {
        ResourceManager.INSTANCE.changeResource(new Locale("uk"));

        Car car1 = car().withId(1).withVendor("Toyota").withModel("Auris").withYear(2008).withType(Type.HATCHBACK)
                           .withColor(Color.GREEN).withMaxSpeed(250).withFuelConsumption(4).withValue(2000).build();

        Car car2 = car().withId(2).withVendor("Mercedes").withModel("E Class").withYear(2003).withType(Type.SEDAN)
                           .withColor(Color.GREY).withMaxSpeed(240).withFuelConsumption(7).withValue(3800).build();

        Car car3 = car().withId(3).withVendor("Honda").withModel("Fit").withYear(2004).withType(Type.HATCHBACK)
                           .withColor(Color.YELLOW).withMaxSpeed(200).withFuelConsumption(3).withValue(4000).build();

        Car car4 = car().withId(4).withVendor("Subaru").withModel("Impreza").withYear(2005).withType(Type.SEDAN)
                           .withColor(Color.GREEN).withMaxSpeed(190).withFuelConsumption(9).withValue(3000).build();

        Car car5 = car().withId(5).withVendor("Nissan").withModel("Lafesta").withYear(2008).withType(Type.MINI_VAN)
                           .withColor(Color.GREEN).withMaxSpeed(300).withFuelConsumption(2).withValue(5500).build();

        Car car6 = car().withId(6).withVendor("Suzuki").withModel("Splash").withYear(2010).withType(Type.MINI_VAN)
                           .withColor(Color.GREEN).withMaxSpeed(300).withFuelConsumption(2).withValue(5500).build();

        Car car7 = car().withId(7).withVendor("CHEVROLET").withModel("MW WAGON").withYear(2009).withType(Type.WAGON)
                           .withColor(Color.GREEN).withMaxSpeed(220).withFuelConsumption(2).withValue(5500).build();

        Car car8 = car().withId(8).withVendor("Mazda").withModel("RX8").withYear(2006).withType(Type.COUPE)
                           .withColor(Color.RED).withMaxSpeed(270).withFuelConsumption(8).withValue(7500).build();

        Car car9 = car().withId(9).withVendor("BMW").withModel("6 SERIES").withYear(2014).withType(Type.COUPE)
                           .withColor(Color.ORANGE).withMaxSpeed(350).withFuelConsumption(10).withValue(30500).build();

        Car car10 = car().withId(10).withVendor("Mitsubishi").withModel("Colt Plus").withYear(2006).withType(Type.HATCHBACK)
                            .withColor(Color.VIOLET).withMaxSpeed(265).withFuelConsumption(6).withValue(1900).build();


        TaxiPark taxiPark = new TaxiPark(car1, car2, car3, car4, car5);

        view.printWelcome();

        view.printAllCars(taxiPark.getCars());
        view.printSortedByFuelConsumptionAsc(taxiPark.sortByFuelConsumptionAsc());

        view.printTotalValue(taxiPark.calculateTotalValue());
        view.printCarsWithinSpeedRange(190, 260, taxiPark.findCarsWithinGivenMaxSpeedRange(190, 260));

    }
}
