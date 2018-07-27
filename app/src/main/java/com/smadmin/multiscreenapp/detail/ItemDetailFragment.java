package com.smadmin.multiscreenapp.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.smadmin.multiscreenapp.R;
import com.smadmin.multiscreenapp.base.BaseFragment;
import com.smadmin.multiscreenapp.items.model.StubItem;

public class ItemDetailFragment extends BaseFragment implements ItemDetailViewContract {

    private static final String ARGS_ITEM = "args_item";

    @InjectPresenter
    ItemDetailPresenter detailPresenter;

    private TextView tvItemId;
    private TextView tvItemContent;
    private TextView tvItemDetails;
    private ImageView ivStar;

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
        tvItemId = getActivity().findViewById(R.id.tv_item_id);
        tvItemContent = getActivity().findViewById(R.id.tv_item_content);
        tvItemDetails = getActivity().findViewById(R.id.tv_item_details);
        ivStar = getActivity().findViewById(R.id.iv_star);
        fillData();
    }

    private void fillData() {
        if (getArguments() != null) {
            Bundle args = getArguments();
            StubItem stubItem = args.getParcelable(ARGS_ITEM);
            tvItemId.setText(stubItem != null ? stubItem.getId() : "No id");
            tvItemContent.setText(stubItem != null ? stubItem.getContent() : "No content");
            tvItemDetails.setText(stubItem != null ? stubItem.getDetails() : "No details");
            ivStar.setImageResource(stubItem.isFavoriteStatus() ?
                    R.drawable.ic_star_favorite : R.drawable.ic_star_unfavorite);
        }
    }
}
