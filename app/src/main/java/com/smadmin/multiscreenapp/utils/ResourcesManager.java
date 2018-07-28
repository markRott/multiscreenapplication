package com.smadmin.multiscreenapp.utils;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.support.annotation.BoolRes;
import android.support.v7.app.AppCompatActivity;

import com.smadmin.multiscreenapp.R;

public final class ResourcesManager {

    private final Resources resources;

    public ResourcesManager(final Context context) {
        this.resources = context.getResources();
    }

    public boolean getBoolean(@BoolRes int resId) {
        return resources.getBoolean(resId);
    }

    public void setScreenOrientation(final AppCompatActivity activity) {
        if (isTabletOrientation()) {
            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        } else {
            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

    public boolean isTabletOrientation() {
        return getBoolean(R.bool.tablet);
    }
}
