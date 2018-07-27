package com.smadmin.multiscreenapp.navigator;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.smadmin.multiscreenapp.R;

import ru.terrakok.cicerone.Router;

public final class PhoneNavigator extends BaseNavigator {

    public PhoneNavigator(AppCompatActivity appCompatActivity, FragmentManager fragmentManager, Router router) {
        super(appCompatActivity, fragmentManager, router);
    }

    @Override
    int getContainerId() {
        return R.id.left_frame_layout_list;
    }

    @Override
    public void openScreen(String screenKey, Object data) {
        router.navigateTo(screenKey, data);
    }
}
