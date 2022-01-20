package com.jab125.example.crackers;

import net.fabricmc.api.ModInitializer;

public class ExampleModCrackers implements ModInitializer, ExampleModCrackersClass {
    @Override
    public void onInitialize() {
        System.out.println(this.modId() + " initialized!");
    }
}
