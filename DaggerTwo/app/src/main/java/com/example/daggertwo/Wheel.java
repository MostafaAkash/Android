package com.example.daggertwo;

import javax.inject.Inject;

public class Wheel {
    private Rim rims;
    private Tires tires;

    public Wheel(Rim rims, Tires tires) {
        this.rims = rims;
        this.tires = tires;
    }
}
