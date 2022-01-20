package com.jab125.example.cheese;

import net.fabricmc.api.ModInitializer;

public class ExampleModCheese implements ModInitializer, ExampleModCheeseClass {
    @Override
    public void onInitialize() {
        System.out.println(this.modId() + " initialized!");
    }
}
