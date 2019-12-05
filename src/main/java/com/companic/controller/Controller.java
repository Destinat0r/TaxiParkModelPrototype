package com.companic.controller;

import com.companic.model.entity.Color;
import com.companic.model.entity.Body;
import com.companic.model.entity.PassengerCar;
import com.companic.utils.ResourceManager;
import com.companic.view.View;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.Arrays;
import java.util.Locale;

import static com.companic.model.entity.PassengerCarBuilder.passengerCar;

public class Controller {

    private View view;

    public Controller(View view) {
        this.view = view;
    }

    public void run() {
        ResourceManager.INSTANCE.changeLocale(new Locale("uk"));

        PassengerCar car1 = passengerCar().withLicense("12GH1G5").withVendor("Toyota").withModel("Auris").withYear(2008)
                                    .withBody(Body.HATCHBACK).withColor(Color.GREEN).withMaxSpeed(250)
                                    .withFuelConsumption(4).withValue(2000).withPassengersAmount(4).build();

        PassengerCar car2 = passengerCar().withLicense("G40B0SQ").withVendor("Mercedes").withModel("E Class")
                                    .withYear(2003).withBody(Body.SEDAN).withColor(Color.GREY).withMaxSpeed(240)
                                    .withFuelConsumption(7).withValue(3800).withPassengersAmount(4).build();

        PassengerCar car3 = passengerCar().withLicense("7FOIJ4M").withVendor("Honda").withModel("Fit").withYear(2004).withBody(Body.HATCHBACK)
                           .withColor(Color.YELLOW).withMaxSpeed(200).withFuelConsumption(3).withValue(4000).withPassengersAmount(4).build();

        PassengerCar car4 = passengerCar().withLicense("J45V9MM").withVendor("Subaru").withModel("Impreza").withYear(2005).withBody(Body.SEDAN)
                           .withColor(Color.GREEN).withMaxSpeed(190).withFuelConsumption(9).withValue(3000).withPassengersAmount(4).build();

        PassengerCar car5 = passengerCar().withLicense("8N23KD0").withVendor("Nissan").withModel("Lafesta").withYear(2008).withBody(Body.MINI_VAN)
                           .withColor(Color.GREEN).withMaxSpeed(300).withFuelConsumption(2).withValue(5500).withPassengersAmount(4).build();

        PassengerCar car6 = passengerCar().withLicense("3FJNSV9").withVendor("Suzuki").withModel("Splash").withYear(2010).withBody(Body.MINI_VAN)
                           .withColor(Color.GREEN).withMaxSpeed(300).withFuelConsumption(2).withValue(5500).withPassengersAmount(4).build();

        PassengerCar car7 = passengerCar().withLicense("8GML1F4").withVendor("CHEVROLET").withModel("MW WAGON").withYear(2009).withBody(Body.WAGON)
                           .withColor(Color.GREEN).withMaxSpeed(220).withFuelConsumption(2).withValue(5500).withPassengersAmount(4).build();

        PassengerCar car8 = passengerCar().withLicense("KN39FH3").withVendor("Mazda").withModel("RX8").withYear(2006).withBody(Body.COUPE)
                           .withColor(Color.RED).withMaxSpeed(270).withFuelConsumption(8).withValue(7500).withPassengersAmount(4).build();

        PassengerCar car9 = passengerCar().withLicense("9GHEVD0").withVendor("BMW").withModel("6 SERIES").withYear(2014).withBody(Body.COUPE)
                           .withColor(Color.ORANGE).withMaxSpeed(350).withFuelConsumption(10).withPassengersAmount(4).withValue(30500).build();

        PassengerCar car10 = passengerCar().withLicense("23RFS1X").withVendor("Mitsubishi").withModel("Colt Plus").withYear(2006).withBody(Body.HATCHBACK)
                            .withColor(Color.VIOLET).withMaxSpeed(265).withFuelConsumption(6).withPassengersAmount(4).withValue(1900).build();
        //
        //        Truck car11 = truck().withVendor("Nissan").withLicense("9FH4SL9").withModel("Lafesta").withYear(2008).withDuty(Duty.LIGHT).withPayload(2000)
        //                       .withColor(Color.GREEN).withMaxSpeed(150).withFuelConsumption(10).withValue(7500).build();
        //
        //        Truck car12 = truck().withVendor("Nissan").withLicense("4RSL95H").withModel("Lafesta").withYear(2008).withDuty(Duty.MEDIUM).withPayload(5000)
        //                       .withColor(Color.BLUE).withMaxSpeed(140).withFuelConsumption(15).withValue(17500).build();;
        //
        //
        //        TaxiPark taxiPark = new TaxiPark(car1, car2, car3, car4, car5, car6, car7, car8, car9, car10, car11, car12);
        //
        //        view.printWelcome();
        //        view.print("");
        //        view.printAllCars(taxiPark.getCars());
        //        view.print("");
        //        view.printSortedByFuelConsumptionAsc(taxiPark.sortByFuelConsumptionAsc());
        //        view.print("");
        //        view.printTotalValue(taxiPark.calculateTotalValue());
        //        view.print("");
        //        view.printCarsWithinSpeedRange(130, 260, taxiPark.findCarsWithinGivenMaxSpeedRange(130, 260));

//        PassengerCar[] cars = {car1, car2, car3, car4, car5, car6, car7, car8, car9, car10};


        Gson gson = new GsonBuilder().setPrettyPrinting().create();


//        try (FileWriter writer = new FileWriter("passenger_cars.json")) {
//                gson.toJson(cars, writer);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        PassengerCar[] cars = null;

        try (Reader reader = new FileReader("passenger_cars.json")) {
            cars = gson.fromJson(reader, PassengerCar[].class);
        } catch(Exception e) {
            e.printStackTrace();
        }
        view.printAllCars(Arrays.asList(cars));
}

}