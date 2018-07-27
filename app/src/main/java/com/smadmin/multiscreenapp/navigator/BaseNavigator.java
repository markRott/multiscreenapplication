package com.smadmin.multiscreenapp.navigator;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.smadmin.multiscreenapp.utils.FragmentFactory;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.android.SupportFragmentNavigator;
import ru.terrakok.cicerone.commands.Command;

public abstract class BaseNavigator {

    protected Router router;
    private FragmentManager fragmentManager;
    private AppCompatActivity appCompatActivity;

    BaseNavigator(AppCompatActivity appCompatActivity, FragmentManager fragmentManager, Router router) {
        this.appCompatActivity = appCompatActivity;
        this.fragmentManager = fragmentManager;
        this.router = router;
    }

    public final Navigator getCiceroneNavigator() {
        Navigator ciceroneNavigator = new
                SupportFragmentNavigator(fragmentManager, getContainerId()) {

                    @Override
                    protected Fragment createFragment(String screenKey, Object data) {
                        return FragmentFactory.getFragmentByKey(screenKey, data);
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

        return ciceroneNavigator;
    }

    abstract int getContainerId();

    public abstract void openScreen(String screenKey, Object data);
}
