package com.smadmin.multiscreenapp.di.list;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class SupportrFragmentManagerModule {

    @Provides
    @ActivityScope
    public FragmentManager provideFragmentManager(AppCompatActivity appCompatActivity) {
        return appCompatActivity.getSupportFragmentManager();
    }

    public interface Expose {
        FragmentManager fragmentManager();
    }
}
