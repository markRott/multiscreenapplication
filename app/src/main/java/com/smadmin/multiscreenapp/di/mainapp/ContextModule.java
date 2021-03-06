package com.smadmin.multiscreenapp.di.mainapp;

import android.content.Context;

import com.smadmin.multiscreenapp.MyApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    private MyApp app;

    public ContextModule(final MyApp app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return app;
    }

    public interface Expose {
        Context context();
    }
}
