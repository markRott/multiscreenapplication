package com.smadmin.multiscreenapp.di.mainapp;

import com.smadmin.multiscreenapp.utils.RxBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UtilsModule {

    @Singleton
    @Provides
    public RxBus provideRxBus() {
        return new RxBus();
    }

    public interface Expose {
        RxBus rxBus();
    }
}
