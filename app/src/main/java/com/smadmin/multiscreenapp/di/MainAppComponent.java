package com.smadmin.multiscreenapp.di;

import com.smadmin.multiscreenapp.MainActivity;
import com.smadmin.multiscreenapp.items.ItemsListPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        ContextModule.class,
        NavigationModule.class,
        ResourcesModule.class
})
public interface MainAppComponent extends ContextModule.Expose, NavigationModule.Expose,
        ResourcesModule.Expose {

    void inject(MainActivity mainActivity);

    void inject(ItemsListPresenter itemsListPresenter);
}
