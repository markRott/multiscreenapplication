package com.smadmin.multiscreenapp.di.list;

import com.smadmin.multiscreenapp.favorite.FavoriteManager;
import com.smadmin.multiscreenapp.utils.ResourcesManager;
import com.smadmin.multiscreenapp.utils.RxBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class FavoriteModule {

    @Provides
    @ActivityScope
    public FavoriteManager provideFavoriteManager(
            final RxBus rxBus,
            final ResourcesManager resourcesManager) {
        return new FavoriteManager(rxBus, resourcesManager);
    }

    public interface Expose {
        FavoriteManager favoriteManager();
    }
}
