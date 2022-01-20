package com.jab125.example.cheese;

import com.jab125.example.base.ExampleModClass;

public interface ExampleModCheeseClass extends ExampleModClass {
    @Override
    default String modId() {
        return "examplemod-cheese";
    }
}
