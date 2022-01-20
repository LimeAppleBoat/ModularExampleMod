package com.jab125.example.crackers;

import com.jab125.example.base.ExampleModClass;

public interface ExampleModCrackersClass extends ExampleModClass {
    @Override
    default String modId() {
        return "examplemod-crackers";
    }
}
