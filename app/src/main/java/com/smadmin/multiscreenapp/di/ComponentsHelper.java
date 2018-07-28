package com.smadmin.multiscreenapp.di;

import android.support.v7.app.AppCompatActivity;

import com.smadmin.multiscreenapp.MyApp;
import com.smadmin.multiscreenapp.di.list.ActivityComponent;
import com.smadmin.multiscreenapp.di.list.ActivityModule;
import com.smadmin.multiscreenapp.di.list.DaggerActivityComponent;
import com.smadmin.multiscreenapp.di.list.NavigatorManagerModule;
import com.smadmin.multiscreenapp.di.list.SupportrFragmentManagerModule;
import com.smadmin.multiscreenapp.di.mainapp.CiceroneNavigationModule;
import com.smadmin.multiscreenapp.di.mainapp.ContextModule;
import com.smadmin.multiscreenapp.di.mainapp.DaggerMainAppComponent;
import com.smadmin.multiscreenapp.di.mainapp.MainAppComponent;
import com.smadmin.multiscreenapp.di.mainapp.ResourcesModule;
import com.smadmin.multiscreenapp.di.mainapp.UtilsModule;

public class ComponentsHelper {

    private static MainAppComponent mainAppComponent;
    private static ActivityComponent activityComponent;

    private ComponentsHelper() {
    }

    public static MainAppComponent initMainAppComponent(final MyApp application) {
        if (mainAppComponent != null) return mainAppComponent;
        return mainAppComponent = DaggerMainAppComponent.builder()
                .contextModule(new ContextModule(application))
                .ciceroneNavigationModule(new CiceroneNavigationModule())
                .resourcesModule(new ResourcesModule())
                .utilsModule(new UtilsModule())
                .build();
//        return null;
    }

    public static ActivityComponent initActivityComponent(final AppCompatActivity appCompatActivity) {
        if (activityComponent != null) return activityComponent;
        return activityComponent = DaggerActivityComponent
                .builder()
                .mainAppComponent(mainAppComponent)
                .activityModule(new ActivityModule(appCompatActivity))
                .supportrFragmentManagerModule(new SupportrFragmentManagerModule())
                .navigatorManagerModule(new NavigatorManagerModule())
                .build();
//        return null;
    }

    public static MainAppComponent getMainAppComponent() {
        return mainAppComponent;
    }

    public static ActivityComponent getActivityComponent() {
        return activityComponent;
    }
}
