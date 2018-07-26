package com.smadmin.multiscreenapp.utils;

import android.support.v4.app.Fragment;

import com.smadmin.multiscreenapp.Const;
import com.smadmin.multiscreenapp.detail.ItemDetailFragment;
import com.smadmin.multiscreenapp.items.model.StubItem;

public class FragmentFactory {

    private FragmentFactory(){}

    public static Fragment getFragmentByKey(final String key, final Object data) {
        switch (key) {
            case Const.ScreenKey.DETAIL_SCREEN:
                return ItemDetailFragment.newInstance((StubItem) data);

            default:
                return null;
        }
    }
}
