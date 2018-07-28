package com.smadmin.multiscreenapp.detail;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.smadmin.multiscreenapp.base.BasePresenter;
import com.smadmin.multiscreenapp.base.SimpleDisposableObserver;
import com.smadmin.multiscreenapp.di.ComponentsHelper;
import com.smadmin.multiscreenapp.items.model.StubItem;
import com.smadmin.multiscreenapp.utils.ResourcesManager;
import com.smadmin.multiscreenapp.utils.RxBus;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

@InjectViewState
public class ItemDetailPresenter extends BasePresenter<ItemDetailViewContract> {

    private static final String TAG = ItemDetailPresenter.class.getSimpleName();

    @Inject
    RxBus rxBus;
    @Inject
    ResourcesManager resourcesManager;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        inject();
        Log.d(TAG, "onFirstViewAttach");
        listenFavoriteStatusChanges();
    }

    private void inject() {
        ComponentsHelper.getActivityComponent().inject(this);
    }

    public void updateFavoriteRequest(final StubItem stubItem) {
        // TODO: Send request to server
        boolean currFavoriteState = stubItem.isFavoriteStatus();
        stubItem.setFavoriteStatus(!currFavoriteState);

        // TODO: Success response from server
        getViewState().setupImageStar();
        notify(stubItem);
    }

    private void notify(StubItem stubItem) {
        rxBus.sendData(stubItem);
    }

    private void listenFavoriteStatusChanges() {
        if (resourcesManager.isTabletOrientation()) {
            Disposable disposable = rxBus.getSubject()
                    .subscribeWith(new SimpleDisposableObserver<Object>() {
                        @Override
                        public void onNext(Object data) {
                            handleFavoriteStatus(data);
                        }
                    });
            addDisposable(disposable);
        }
    }

    private void handleFavoriteStatus(Object data) {
        if (data instanceof StubItem) {
            getViewState().setupImageStar();
        }
    }
}
