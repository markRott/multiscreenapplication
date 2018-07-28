package com.smadmin.multiscreenapp.items;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.smadmin.multiscreenapp.R;
import com.smadmin.multiscreenapp.base.BaseFragment;
import com.smadmin.multiscreenapp.base.IRecyclerItemTouchListener;
import com.smadmin.multiscreenapp.items.model.GenerateStubItems;
import com.smadmin.multiscreenapp.items.model.StubItem;

public class ItemsListFragment extends BaseFragment
        implements IRecyclerItemTouchListener<StubItem>, ItemsListViewContract, IFavoriteTouch {

    private ItemAdapter itemAdapter;

    @InjectPresenter
    ItemsListPresenter itemsListPresenter;

    public static ItemsListFragment newInstance() {
        Bundle args = new Bundle();
        ItemsListFragment fragment = new ItemsListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_items_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initRecyclerView();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (itemAdapter != null) {
            itemAdapter.setItemTouchListener(this);
        }
    }

    @Override
    public void onPause() {
        if (itemAdapter != null) {
            itemAdapter.setItemTouchListener(null);
        }
        super.onPause();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = getActivity().findViewById(R.id.left_items_list);
        if (recyclerView != null) {
            initAdapter();
            recyclerView.setAdapter(itemAdapter);
            recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),
                    DividerItemDecoration.VERTICAL));
        }
    }

    private void initAdapter() {
        itemAdapter = new ItemAdapter(this);
        itemAdapter.setData(GenerateStubItems.ITEMS);
    }

    @Override
    public void updateFavoriteState(int position) {
        itemAdapter.notifyItemChanged(position);
    }

    @Override
    public void updateFavoriteState(final StubItem stubItem) {
        if (itemAdapter.getData() == null || itemAdapter.isEmpty()) return;
        int updatePosition = itemsListPresenter
                .searchItemPosition(itemAdapter.getData(), stubItem.getId());
        itemAdapter.notifyItemChanged(updatePosition);
    }

    @Override
    public void onTouch(int position, StubItem data) {
        itemsListPresenter.openDetailScreen(data);
    }

    @Override
    public void onStarClick(int position, StubItem stubItem) {
        itemsListPresenter.favoriteAction(position, stubItem);
    }
}
