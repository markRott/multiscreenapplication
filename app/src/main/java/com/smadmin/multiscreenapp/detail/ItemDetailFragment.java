package com.smadmin.multiscreenapp.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smadmin.multiscreenapp.R;
import com.smadmin.multiscreenapp.base.BaseFragment;
import com.smadmin.multiscreenapp.items.model.StubItem;

public class ItemDetailFragment extends BaseFragment {

    private static final String ARGS_ITEM = "args_item";
    private TextView tvItemData;

    public static ItemDetailFragment newInstance(StubItem stubItem) {
        final ItemDetailFragment fragment = new ItemDetailFragment();
        final Bundle args = new Bundle();
        args.putParcelable(ARGS_ITEM, stubItem);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvItemData = getActivity().findViewById(R.id.tv_item_data);
        fillData();
    }

    private void fillData() {
        if (getArguments() != null) {
            Bundle args = getArguments();
            StubItem stubItem = args.getParcelable(ARGS_ITEM);
            tvItemData.setText(stubItem != null ? stubItem.toString() : "No item data");
        }
    }
}
