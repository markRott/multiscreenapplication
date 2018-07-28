package com.smadmin.multiscreenapp.detail;

import com.arellomobile.mvp.InjectViewState;
import com.smadmin.multiscreenapp.base.BasePresenter;
import com.smadmin.multiscreenapp.di.ComponentsHelper;
import com.smadmin.multiscreenapp.favorite.FavoriteManager;
import com.smadmin.multiscreenapp.favorite.IHandleFavoriteStatus;
import com.smadmin.multiscreenapp.items.model.StubItem;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

@InjectViewState
public class ItemDetailPresenter extends BasePresenter<ItemDetailViewContract>
        implements IHandleFavoriteStatus<StubItem> {

    private static final String TAG = ItemDetailPresenter.class.getSimpleName();

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

    public void updateFavoriteRequest(final StubItem stubItem) {
        // TODO: Send request to server
        boolean currFavoriteState = stubItem.isFavoriteStatus();
        stubItem.setFavoriteStatus(!currFavoriteState);
        // TODO: Success response from server
        getViewState().setupImageStar();
        favoriteManager.notify(stubItem);
    }

    @Override
    public void handleFavoriteStatus(StubItem data) {
        getViewState().setupImageStar();
    }
}
