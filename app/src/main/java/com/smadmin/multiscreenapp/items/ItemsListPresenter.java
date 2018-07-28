package com.smadmin.multiscreenapp.items;

import android.support.annotation.CheckResult;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.smadmin.multiscreenapp.Const;
import com.smadmin.multiscreenapp.base.BasePresenter;
import com.smadmin.multiscreenapp.base.SimpleDisposableObserver;
import com.smadmin.multiscreenapp.di.ComponentsHelper;
import com.smadmin.multiscreenapp.items.model.StubItem;
import com.smadmin.multiscreenapp.navigator.NavigatorManager;
import com.smadmin.multiscreenapp.utils.ResourcesManager;
import com.smadmin.multiscreenapp.utils.RxBus;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

@InjectViewState
public class ItemsListPresenter extends BasePresenter<ItemsListViewContract> {

    private static final String TAG = ItemsListPresenter.class.getSimpleName();

    @Inject
    NavigatorManager navigatorManager;
    @Inject
    ResourcesManager resourcesManager;
    @Inject
    RxBus rxBus;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        inject();
        listenFavoriteStatusChanges();
        Log.d(TAG, "onFirstViewAttach");
    }

    private void inject() {
        ComponentsHelper.getActivityComponent().inject(this);
    }

    public void openDetailScreen(StubItem stubItem) {
        navigatorManager.getBaseNavigator().openScreen(Const.ScreenKey.DETAIL_SCREEN, stubItem);
    }

    public void favoriteAction(int position, StubItem stubItem) {
        boolean currFavoriteState = stubItem.isFavoriteStatus();
        stubItem.setFavoriteStatus(!currFavoriteState);
        getViewState().updateFavoriteState(position);
    }

    @CheckResult
    public int searchItemPosition(List<StubItem> collection, String itemId) {
        int updatePosition = 0;
        StubItem currItem;
        if (collection == null || collection.isEmpty()) return updatePosition;
        for (int i = 0; i < collection.size(); i++) {
            currItem = collection.get(i);
            if (Objects.equals(itemId, currItem.getId())) {
                updatePosition = i;
                return updatePosition;
            }
        }
        return updatePosition;
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
            StubItem stubItem = (StubItem) data;
            getViewState().updateFavoriteState(stubItem);
        }
    }
}
