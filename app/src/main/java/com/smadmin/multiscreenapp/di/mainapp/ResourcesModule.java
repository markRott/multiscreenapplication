package com.smadmin.multiscreenapp.di.mainapp;

import android.content.Context;
import android.content.res.Resources;

import com.smadmin.multiscreenapp.utils.ResourcesManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ResourcesModule {

    @Provides
    @Singleton
    public ResourcesManager provideResources(final Context context) {
        return new ResourcesManager(context);
    }

    public interface Expose {
        ResourcesManager resourcesManager();
    }
}
