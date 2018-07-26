package com.smadmin.multiscreenapp.items;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smadmin.multiscreenapp.R;
import com.smadmin.multiscreenapp.base.BaseRecyclerAdapter;
import com.smadmin.multiscreenapp.items.model.StubItem;

public class ItemAdapter extends BaseRecyclerAdapter<StubItem, ItemAdapter.ItemViewHolder> {

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_list_content, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        fillData(holder, position);
    }

    private void fillData(ItemViewHolder holder, int position) {
        final StubItem model = getItemByPosition(position);
        holder.idView.setText(data.get(position).id);
        holder.contentView.setText(data.get(position).content);
        holder.itemView.setTag(data.get(position));
        setupItemTouchListener(holder.rootView, position, model);
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {

        final View rootView;
        final TextView idView;
        final TextView contentView;

        ItemViewHolder(View view) {
            super(view);
            rootView = view;
            idView = view.findViewById(R.id.id_text);
            contentView = view.findViewById(R.id.content);
        }
    }
}
