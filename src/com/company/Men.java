package com.company;

public class Men extends Human {

    public Men(String name, String surName, float height, float weight) {
        super(true, name, surName, height, weight);
    }

    @Override
    public String toString() {
        return "Men " + super.toString();
    }
}
