package com.smadmin.multiscreenapp.navigator;

import android.support.v7.app.AppCompatActivity;

import ru.terrakok.cicerone.Navigator;

public final class NavigatorManager {

    private boolean tabletMode;
    private BaseNavigator baseNavigator;
    private AppCompatActivity appCompatActivity;

    public NavigatorManager(AppCompatActivity appCompatActivity, boolean tabletMode) {
        this.appCompatActivity = appCompatActivity;
        this.tabletMode = tabletMode;
    }

    public Navigator getNavigator() {
        if (tabletMode) {
            baseNavigator = new TabletNavigator(appCompatActivity);
        } else {
            baseNavigator = new PhoneNavigator(appCompatActivity);
        }
        return baseNavigator.getNavigator();
    }
}
