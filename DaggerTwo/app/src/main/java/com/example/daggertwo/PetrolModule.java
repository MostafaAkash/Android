package com.example.daggertwo;


import dagger.Module;
import dagger.Provides;

@Module
public class PetrolModule {
    private int horsePower;

    public PetrolModule(int horsePower) {
        this.horsePower = horsePower;
    }

    @Provides
    Engine provideEngine()
    {
        return new PetrolEngine(horsePower);
    }
}
