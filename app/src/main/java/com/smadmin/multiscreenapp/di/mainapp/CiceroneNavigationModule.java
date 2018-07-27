package com.smadmin.multiscreenapp.di.mainapp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

@Module
public class CiceroneNavigationModule {

    private Cicerone<Router> cicerone;

    public CiceroneNavigationModule() {
        cicerone = Cicerone.create();
    }

    @Provides
    @Singleton
    Router provideRouter() {
        return cicerone.getRouter();
    }

    @Provides
    @Singleton
    NavigatorHolder provideNavigatorHolder() {
        return cicerone.getNavigatorHolder();
    }

    public interface Expose {
        Router router();

        NavigatorHolder navigatorHolder();
    }
}
