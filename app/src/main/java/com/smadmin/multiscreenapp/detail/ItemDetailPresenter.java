package com.smadmin.multiscreenapp.detail;

import com.arellomobile.mvp.InjectViewState;
import com.smadmin.multiscreenapp.base.BasePresenter;
import com.smadmin.multiscreenapp.items.model.StubItem;

@InjectViewState
public class ItemDetailPresenter extends BasePresenter<ItemDetailViewContract> {

    public void updateFavoriteRequest(final StubItem stubItem){
        // TODO: Send request to server
        boolean currFavoriteState = stubItem.isFavoriteStatus();
        stubItem.setFavoriteStatus(!currFavoriteState);

        // TODO: Success response from server
        getViewState().setupImageStar();
    }
}
