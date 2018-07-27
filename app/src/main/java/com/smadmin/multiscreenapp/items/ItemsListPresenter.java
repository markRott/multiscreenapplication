package com.smadmin.multiscreenapp.items;

import com.arellomobile.mvp.InjectViewState;
import com.smadmin.multiscreenapp.Const;
import com.smadmin.multiscreenapp.base.BasePresenter;
import com.smadmin.multiscreenapp.di.ComponentsHelper;
import com.smadmin.multiscreenapp.items.model.StubItem;
import com.smadmin.multiscreenapp.navigator.NavigatorManager;

import javax.inject.Inject;

@InjectViewState
public class ItemsListPresenter extends BasePresenter<ItemsListViewContract> {

    @Inject
    NavigatorManager navigatorManager;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        inject();
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
}
