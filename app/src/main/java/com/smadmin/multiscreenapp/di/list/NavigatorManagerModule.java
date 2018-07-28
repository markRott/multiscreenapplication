package com.smadmin.multiscreenapp.di.list;

import android.content.res.Resources;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.smadmin.multiscreenapp.R;
import com.smadmin.multiscreenapp.navigator.BaseNavigator;
import com.smadmin.multiscreenapp.navigator.NavigatorManager;
import com.smadmin.multiscreenapp.navigator.PhoneNavigator;
import com.smadmin.multiscreenapp.navigator.TabletNavigator;
import com.smadmin.multiscreenapp.utils.ResourcesManager;

import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.Router;

@Module
public class NavigatorManagerModule {

    @Provides
    @ActivityScope
    public BaseNavigator provideBaseNavigator(
            final AppCompatActivity appCompatActivity,
            final FragmentManager fragmentManager,
            final Router router,
            final ResourcesManager resourcesManager) {

        final boolean isTablet = resourcesManager.getBoolean(R.bool.tablet);
        BaseNavigator baseNavigator;
        if (isTablet) {
            baseNavigator = new TabletNavigator(appCompatActivity, fragmentManager, router);
        } else {
            baseNavigator = new PhoneNavigator(appCompatActivity, fragmentManager, router);
        }
        return baseNavigator;
    }

    @Provides
    @ActivityScope
    public NavigatorManager provideNavigatorManager(final BaseNavigator baseNavigator) {
        return new NavigatorManager(baseNavigator);
    }

    public interface Expose {
        NavigatorManager navigatorManager();
    }
}
