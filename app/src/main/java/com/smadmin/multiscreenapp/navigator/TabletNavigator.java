package com.smadmin.multiscreenapp.navigator;

import android.support.v7.app.AppCompatActivity;

import com.smadmin.multiscreenapp.R;

final class TabletNavigator extends BaseNavigator {

    TabletNavigator(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
    }

    @Override
    int getContainerId() {
        return R.id.tablet_frame_layout_detail;
    }
}
