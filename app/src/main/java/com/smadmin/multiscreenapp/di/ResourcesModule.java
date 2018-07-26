package com.smadmin.multiscreenapp.di;

import android.content.Context;
import android.content.res.Resources;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ResourcesModule {

    @Provides
    @Singleton
    public Resources provideResources(Context context) {
        return context.getResources();
    }

    public interface Expose {
        Resources resources();
    }
}
