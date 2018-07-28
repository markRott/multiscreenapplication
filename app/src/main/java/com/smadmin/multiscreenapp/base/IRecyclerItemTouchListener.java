package com.smadmin.multiscreenapp.base;

public interface IRecyclerItemTouchListener<Item> {

    void onTouch(final int position, Item data);
}
