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

    protected final Router router;
    private final FragmentManager fragmentManager;
    private final AppCompatActivity appCompatActivity;

    BaseNavigator(
            final AppCompatActivity appCompatActivity,
            final FragmentManager fragmentManager,
            final Router router) {
        this.appCompatActivity = appCompatActivity;
        this.fragmentManager = fragmentManager;
        this.router = router;
    }

    public final Navigator getCiceroneNavigator() {
        return new
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
    }

    abstract int getContainerId();

    public abstract void openScreen(final String screenKey, final Object data);
}
