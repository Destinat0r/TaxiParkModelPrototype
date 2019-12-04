package com.companic.controller;

import com.companic.model.Color;
import com.companic.model.Body;
import com.companic.model.entity.Car;
import com.companic.model.entity.PassengerCar;
import com.companic.model.entity.TaxiPark;
import com.companic.model.entity.Truck;
import com.companic.util.ResourceManager;
import com.companic.view.View;

import java.util.Locale;

import static com.companic.model.entity.PassengerCarBuilder.passengerCar;

public class Controller {

    private View view;

    public Controller(View view) {
        this.view = view;
    }

    public void run() {
        ResourceManager.INSTANCE.changeResource(new Locale("en"));

        PassengerCar car1 = passengerCar().withVendor("Toyota").withModel("Auris").withYear(2008).withBody(Body.HATCHBACK)
                           .withColor(Color.GREEN).withMaxSpeed(250).withFuelConsumption(4).withValue(2000).withPassengersAmount(4).build();

        PassengerCar car2 = passengerCar().withVendor("Mercedes").withModel("E Class").withYear(2003).withBody(Body.SEDAN)
                           .withColor(Color.GREY).withMaxSpeed(240).withFuelConsumption(7).withValue(3800).withPassengersAmount(4).build();

        PassengerCar car3 = passengerCar().withVendor("Honda").withModel("Fit").withYear(2004).withBody(Body.HATCHBACK)
                           .withColor(Color.YELLOW).withMaxSpeed(200).withFuelConsumption(3).withValue(4000).withPassengersAmount(4).build();

        PassengerCar car4 = passengerCar().withVendor("Subaru").withModel("Impreza").withYear(2005).withBody(Body.SEDAN)
                           .withColor(Color.GREEN).withMaxSpeed(190).withFuelConsumption(9).withValue(3000).withPassengersAmount(4).build();

        PassengerCar car5 = passengerCar().withVendor("Nissan").withModel("Lafesta").withYear(2008).withBody(Body.MINI_VAN)
                           .withColor(Color.GREEN).withMaxSpeed(300).withFuelConsumption(2).withValue(5500).withPassengersAmount(4).build();

        PassengerCar car6 = passengerCar().withVendor("Suzuki").withModel("Splash").withYear(2010).withBody(Body.MINI_VAN)
                           .withColor(Color.GREEN).withMaxSpeed(300).withFuelConsumption(2).withValue(5500).withPassengersAmount(4).build();

        PassengerCar car7 = passengerCar().withVendor("CHEVROLET").withModel("MW WAGON").withYear(2009).withBody(Body.WAGON)
                           .withColor(Color.GREEN).withMaxSpeed(220).withFuelConsumption(2).withValue(5500).withPassengersAmount(4).build();

        PassengerCar car8 = passengerCar().withVendor("Mazda").withModel("RX8").withYear(2006).withBody(Body.COUPE)
                           .withColor(Color.RED).withMaxSpeed(270).withFuelConsumption(8).withValue(7500).withPassengersAmount(4).build();

        PassengerCar car9 = passengerCar().withVendor("BMW").withModel("6 SERIES").withYear(2014).withBody(Body.COUPE)
                           .withColor(Color.ORANGE).withMaxSpeed(350).withFuelConsumption(10).withPassengersAmount(4).withValue(30500).build();

        PassengerCar car10 = passengerCar().withVendor("Mitsubishi").withModel("Colt Plus").withYear(2006).withBody(Body.HATCHBACK)
                            .withColor(Color.VIOLET).withMaxSpeed(265).withFuelConsumption(6).withPassengersAmount(4).withValue(1900).build();


        TaxiPark taxiPark = new TaxiPark(car1, car2, car3, car4, car5, car6, car7, car8, car9, car10);

        view.printWelcome();
        view.print("");
        view.printAllCars(taxiPark.getCars());
        view.print("");
        view.printSortedByFuelConsumptionAsc(taxiPark.sortByFuelConsumptionAsc());
        view.print("");
        view.printTotalValue(taxiPark.calculateTotalValue());
        view.print("");
        view.printCarsWithinSpeedRange(190, 260, taxiPark.findCarsWithinGivenMaxSpeedRange(190, 260));

    }
}
