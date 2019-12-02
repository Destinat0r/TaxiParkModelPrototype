package com.companic;

import com.companic.controller.Controller;
import com.companic.view.View;

public class Main {
    public static void main(String[] args) {
        new Controller(new View()).run();
    }

}
