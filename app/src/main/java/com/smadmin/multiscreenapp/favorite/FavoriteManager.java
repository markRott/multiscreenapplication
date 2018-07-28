package com.smadmin.multiscreenapp.favorite;

import android.support.annotation.CheckResult;

import com.smadmin.multiscreenapp.base.SimpleDisposableObserver;
import com.smadmin.multiscreenapp.items.model.StubItem;
import com.smadmin.multiscreenapp.utils.ResourcesManager;
import com.smadmin.multiscreenapp.utils.RxBus;

import io.reactivex.disposables.Disposable;

public class FavoriteManager {

    private final RxBus rxBus;
    private final ResourcesManager resourcesManager;

    public FavoriteManager(
            final RxBus rxBus,
            final ResourcesManager resourcesManager) {
        this.rxBus = rxBus;
        this.resourcesManager = resourcesManager;
    }

    public void notify(final StubItem stubItem) {
        if (resourcesManager.isTabletOrientation()) {
            rxBus.sendData(stubItem);
        }
    }

    @CheckResult
    public Disposable listenFavoriteStatusChanges(final IHandleFavoriteStatus contract) {
        Disposable disposable = null;
        if (resourcesManager.isTabletOrientation()) {
            disposable = rxBus.getSubject()
                    .subscribeWith(new SimpleDisposableObserver<Object>() {
                        @Override
                        public void onNext(Object data) {
                            if (contract == null) return;
                            contract.handleFavoriteStatus(data);
                        }
                    });
        }
        return disposable;
    }
}
