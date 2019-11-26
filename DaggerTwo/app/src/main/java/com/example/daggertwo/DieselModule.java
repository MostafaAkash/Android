package com.example.daggertwo;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class DieselModule {
    @Binds
   abstract Engine bindEngine(DieselEngine engine);
}
