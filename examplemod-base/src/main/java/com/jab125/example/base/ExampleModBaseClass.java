package com.jab125.example.base;

public interface ExampleModBaseClass extends ExampleModClass {
    @Override
    default String modId() {
        return "examplemod-base";
    }
}
