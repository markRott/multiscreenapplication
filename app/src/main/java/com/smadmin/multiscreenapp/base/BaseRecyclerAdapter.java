package com.smadmin.multiscreenapp.base;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.Collections;
import java.util.List;

public abstract class BaseRecyclerAdapter<Item, Holder extends RecyclerView.ViewHolder>
        extends RecyclerView.Adapter<Holder> {

    protected List<Item> data;
    private IRecyclerItemTouchListener<Item> itemTouchListener;

    public BaseRecyclerAdapter() {
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public void setItemTouchListener(IRecyclerItemTouchListener<Item> itemTouchListener) {
        this.itemTouchListener = itemTouchListener;
    }

    public void setData(@NonNull List<Item> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void addData(Item data) {
        this.data.add(data);
        notifyDataSetChanged();
    }

    public void addAllData(@NonNull List<Item> newData) {
        this.data.addAll(newData);
    }

    public List<Item> getData() {
        return data == null ? Collections.<Item>emptyList() : data;
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public Item getItemByPosition(int position) {
        return data.get(position);
    }

    public void clear() {
        if (data != null) {
            data.clear();
        }
    }

    protected void setupItemTouchListener(View view, final int position, final Item object) {
        if (itemTouchListener == null) return;
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemTouchListener.onTouch(position, object);
            }
        });
    }
}