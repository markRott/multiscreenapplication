package com.smadmin.multiscreenapp.di.list;

import android.support.v7.app.AppCompatActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private AppCompatActivity appCompatActivity;

    public ActivityModule(AppCompatActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
    }

    @Provides
    @ActivityScope
    public AppCompatActivity provideAppCompatActivity() {
        return appCompatActivity;
    }

    public interface Expose {
        AppCompatActivity appCompatActivity();
    }
}
