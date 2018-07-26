package com.smadmin.multiscreenapp;

import android.app.Application;

import com.smadmin.multiscreenapp.di.ComponentsHelper;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ComponentsHelper.initMainAppComponent(this);
    }
}
