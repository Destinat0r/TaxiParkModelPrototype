package com.companic;

import com.companic.model.Car;
import com.companic.model.Color;
import com.companic.model.Type;

import static com.companic.model.CarBuilder.car;

public class Main {
    public static void main(String[] args) {
        Car car = car().withVendor("Toyota").withModel("Auris").withYear(2008).withType(Type.HATCHBACK)
                      .withColor(Color.GREEN).withMaxSpeed(250).withFuelConsumption(4).withAccelerationTime(8)
                      .withValue(2000).build();

        System.out.println(car);

    }


}
