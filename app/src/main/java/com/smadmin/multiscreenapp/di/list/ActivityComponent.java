package com.smadmin.multiscreenapp.di.list;

import com.smadmin.multiscreenapp.MainActivity;
import com.smadmin.multiscreenapp.detail.ItemDetailPresenter;
import com.smadmin.multiscreenapp.di.mainapp.MainAppComponent;
import com.smadmin.multiscreenapp.items.ItemsListPresenter;

import dagger.Component;

@ActivityScope
@Component(
        dependencies = {MainAppComponent.class},
        modules = {
                ActivityModule.class,
                SupportrFragmentManagerModule.class,
                NavigatorManagerModule.class}
)
public interface ActivityComponent extends ActivityModule.Expose,
        SupportrFragmentManagerModule.Expose,
        NavigatorManagerModule.Expose {

    void inject(MainActivity mainActivity);

    void inject(ItemsListPresenter itemsListPresenter);

    void inject(ItemDetailPresenter detailPresenter);
}
