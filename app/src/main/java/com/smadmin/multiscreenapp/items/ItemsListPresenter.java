package com.smadmin.multiscreenapp.items;

import android.support.annotation.CheckResult;

import com.arellomobile.mvp.InjectViewState;
import com.smadmin.multiscreenapp.Const;
import com.smadmin.multiscreenapp.base.BasePresenter;
import com.smadmin.multiscreenapp.di.ComponentsHelper;
import com.smadmin.multiscreenapp.favorite.FavoriteManager;
import com.smadmin.multiscreenapp.favorite.IHandleFavoriteStatus;
import com.smadmin.multiscreenapp.items.model.StubItem;
import com.smadmin.multiscreenapp.navigator.NavigatorManager;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

@InjectViewState
public class ItemsListPresenter extends BasePresenter<ItemsListViewContract>
        implements IHandleFavoriteStatus<StubItem> {

    @Inject
    NavigatorManager navigatorManager;
    @Inject
    FavoriteManager favoriteManager;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        inject();
        listenFavoriteStatus();
    }

    private void inject() {
        ComponentsHelper.getActivityComponent().inject(this);
    }

    private void listenFavoriteStatus() {
        final Disposable disposable = favoriteManager.listenFavoriteStatusChanges(this);
        addDisposable(disposable);
    }

    public void openDetailScreen(final StubItem stubItem) {
        navigatorManager.getBaseNavigator().openScreen(Const.ScreenKey.DETAIL_SCREEN, stubItem);
    }

    public void favoriteAction(final int position, final StubItem stubItem) {
        boolean currFavoriteState = stubItem.isFavoriteStatus();
        stubItem.setFavoriteStatus(!currFavoriteState);
        getViewState().updateFavoriteState(position);
        favoriteManager.notify(stubItem);
    }

    @CheckResult
    public int searchItemPosition(final List<StubItem> collection, final String itemId) {
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

    @Override
    public void handleFavoriteStatus(final StubItem data) {
        getViewState().updateFavoriteState(data);
    }
}
