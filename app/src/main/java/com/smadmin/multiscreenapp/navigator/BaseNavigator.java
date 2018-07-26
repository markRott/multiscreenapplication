package com.smadmin.multiscreenapp.navigator;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.smadmin.multiscreenapp.utils.FragmentFactory;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.android.SupportFragmentNavigator;
import ru.terrakok.cicerone.commands.Command;

public abstract class BaseNavigator {

    private AppCompatActivity appCompatActivity;

    BaseNavigator(AppCompatActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
    }

    public final Navigator getNavigator() {
        Navigator phoneNavigator = new
                SupportFragmentNavigator(appCompatActivity.getSupportFragmentManager(), getContainerId()) {

                    @Override
                    protected Fragment createFragment(String screenKey, Object data) {
                        Fragment fragment = FragmentFactory.getFragmentByKey(screenKey, data);
                        return fragment;
                    }

                    @Override
                    protected void showSystemMessage(String message) {
                    }

                    @Override
                    protected void exit() {
                        appCompatActivity.finish();
                    }

                    @Override
                    public void applyCommand(Command command) {
                        super.applyCommand(command);
                    }
                };

        return phoneNavigator;
    }

    abstract int getContainerId();
}
