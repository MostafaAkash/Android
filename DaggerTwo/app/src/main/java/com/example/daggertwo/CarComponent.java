package com.example.daggertwo;

import dagger.Component;
import dagger.Provides;

@Component (modules = {WheelsModule.class,PetrolModule.class})
public interface CarComponent {

    Car getCar();

    void inject(MainActivity mainActivity);

}
