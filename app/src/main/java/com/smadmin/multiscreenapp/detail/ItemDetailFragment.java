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
import com.smadmin.multiscreenapp.utils.RxBus;

import javax.inject.Inject;

public class ItemDetailFragment extends BaseFragment implements ItemDetailViewContract {

    private static final String ARGS_ITEM = "args_item";

    @InjectPresenter
    ItemDetailPresenter detailPresenter;

    private StubItem stubItem;
    private ImageView ivStar;
    private TextView tvItemId;
    private TextView tvItemContent;
    private TextView tvItemDetails;

    public static ItemDetailFragment newInstance(final StubItem stubItem) {
        final ItemDetailFragment fragment = new ItemDetailFragment();
        final Bundle args = new Bundle();
        args.putParcelable(ARGS_ITEM, stubItem);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        fillViews();
    }

    private void initViews() {
        tvItemId = getActivity().findViewById(R.id.tv_item_id);
        tvItemContent = getActivity().findViewById(R.id.tv_item_content);
        tvItemDetails = getActivity().findViewById(R.id.tv_item_details);
        ivStar = getActivity().findViewById(R.id.iv_star);
    }

    private void fillViews() {
        if (getArguments() != null) {
            Bundle args = getArguments();
            stubItem = args.getParcelable(ARGS_ITEM);
            tvItemId.setText(stubItem != null ? stubItem.getId() : getString(R.string.no_id));
            tvItemContent.setText(stubItem != null ? stubItem.getContent() : getString(R.string.no_content));
            tvItemDetails.setText(stubItem != null ? stubItem.getDetails() : getString(R.string.no_details));
            fillStarView();
        }
    }

    private void fillStarView() {
        setupImageStar();
        ivStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detailPresenter.updateFavoriteRequest(stubItem);
            }
        });
    }

    @Override
    public void setupImageStar() {
        ivStar.setImageResource(stubItem.isFavoriteStatus() ?
                R.drawable.ic_star_favorite : R.drawable.ic_star_unfavorite);
    }
}
