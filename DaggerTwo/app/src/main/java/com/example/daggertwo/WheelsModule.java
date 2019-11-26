package com.example.daggertwo;

import dagger.Module;
import dagger.Provides;

@Module
public class WheelsModule {
    @Provides
    Rim provideRims()
    {
        return new Rim();
    }

    @Provides
    Tires provideTire()
    {
        Tires tires = new Tires();
        tires.inflate();
        return tires;
    }
    @Provides
    Wheel provideWheels(Rim rim,Tires tires)
    {
        return new Wheel(rim,tires);
    }
}
