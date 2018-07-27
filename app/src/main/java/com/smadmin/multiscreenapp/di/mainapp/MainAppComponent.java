package com.smadmin.multiscreenapp.di.mainapp;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        ContextModule.class,
        CiceroneNavigationModule.class,
        ResourcesModule.class
})
public interface MainAppComponent extends ContextModule.Expose, CiceroneNavigationModule.Expose,
        ResourcesModule.Expose {
}
