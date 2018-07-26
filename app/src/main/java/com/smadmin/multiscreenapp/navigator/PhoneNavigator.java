package com.smadmin.multiscreenapp.navigator;

import android.support.v7.app.AppCompatActivity;

import com.smadmin.multiscreenapp.R;

final class PhoneNavigator extends BaseNavigator {

    PhoneNavigator(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
    }

    @Override
    int getContainerId() {
        return R.id.left_frame_layout_list;
    }
}
