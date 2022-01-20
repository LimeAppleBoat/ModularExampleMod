package com.jab125.example.base;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Items;
import net.minecraft.util.registry.Registry;

public class ExampleModBase implements ModInitializer, ExampleModBaseClass {
    @Override
    public void onInitialize() {
        System.out.println(this.modId() + " initialized!");
        // test to see if remapping works
        System.out.println(Registry.ITEM.getId(Items.DIRT));
    }
}
