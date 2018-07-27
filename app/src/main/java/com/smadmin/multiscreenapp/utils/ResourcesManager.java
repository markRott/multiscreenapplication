package com.smadmin.multiscreenapp.utils;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.BoolRes;

public class ResourcesManager {

    private final Resources resources;

    public ResourcesManager(Context context) {
        this.resources = context.getResources();
    }

    public boolean getBoolean(@BoolRes int resId) {
        return resources.getBoolean(resId);
    }
}
