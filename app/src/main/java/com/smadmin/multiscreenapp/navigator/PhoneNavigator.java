package com.smadmin.multiscreenapp.navigator;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.smadmin.multiscreenapp.R;

import ru.terrakok.cicerone.Router;

public final class PhoneNavigator extends BaseNavigator {

    public PhoneNavigator(
            final AppCompatActivity appCompatActivity,
            final FragmentManager fragmentManager,
            final Router router) {
        super(appCompatActivity, fragmentManager, router);
    }

    @Override
    int getContainerId() {
        return R.id.left_frame_layout_list;
    }

    @Override
    public void openScreen(final String screenKey, final Object data) {
        router.navigateTo(screenKey, data);
    }
}
