package com.companic.view;

import com.companic.model.Car;
import com.companic.util.ResourceManager;

import java.util.List;

public class View {

    private ResourceManager resourceManager;

    public View() {
        this.resourceManager = ResourceManager.INSTANCE;
    }

    public void print(String string) {
        System.out.println(string);
    }

    public void printAllCars(List<Car> cars) {
        for (Car car : cars) {
            print(car.toString());
        }
    }
}
