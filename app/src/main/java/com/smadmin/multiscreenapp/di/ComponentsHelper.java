package com.smadmin.multiscreenapp.di;

import com.smadmin.multiscreenapp.MyApp;

public class ComponentsHelper {

    private static MainAppComponent mainAppComponent;

    private ComponentsHelper() {
    }

    public static MainAppComponent initMainAppComponent(MyApp application) {
        if (mainAppComponent != null) return mainAppComponent;
        return mainAppComponent = DaggerMainAppComponent.builder()
                .contextModule(new ContextModule(application))
                .navigationModule(new NavigationModule())
                .resourcesModule(new ResourcesModule())
                .build();
    }

    public static MainAppComponent getMainAppComponent() {
        return mainAppComponent;
    }
}
