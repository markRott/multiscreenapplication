package com.smadmin.multiscreenapp.items;

import com.smadmin.multiscreenapp.base.IBaseMvpView;
import com.smadmin.multiscreenapp.items.model.StubItem;

public interface ItemsListViewContract extends IBaseMvpView {

    void updateFavoriteState(final int position);

    void updateFavoriteState(StubItem stubItem);
}
