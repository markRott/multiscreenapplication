package com.smadmin.multiscreenapp.navigator;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.smadmin.multiscreenapp.R;

import ru.terrakok.cicerone.Router;

public final class TabletNavigator extends BaseNavigator {

    public TabletNavigator(AppCompatActivity appCompatActivity, FragmentManager fragmentManager, Router router) {
        super(appCompatActivity, fragmentManager, router);
    }

    @Override
    int getContainerId() {
        return R.id.tablet_frame_layout_detail;
    }

    @Override
    public void openScreen(String screenKey, Object data) {
        router.replaceScreen(screenKey, data);
    }
}
