package com.smadmin.multiscreenapp.items;

import com.arellomobile.mvp.InjectViewState;
import com.smadmin.multiscreenapp.Const;
import com.smadmin.multiscreenapp.base.BasePresenter;
import com.smadmin.multiscreenapp.di.ComponentsHelper;
import com.smadmin.multiscreenapp.items.model.StubItem;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class ItemsListPresenter extends BasePresenter<ItemsListViewContract> {

    @Inject
    Router router;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        inject();
    }

    private void inject() {
        ComponentsHelper.getMainAppComponent().inject(this);
    }

    public void openDetailScreen(StubItem stubItem) {
        System.out.println("stubItem = " + stubItem);
        router.navigateTo(Const.ScreenKey.DETAIL_SCREEN, stubItem);
    }
}
