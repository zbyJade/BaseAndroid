package com.zc.zby.basicframedemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.zc.zby.basicframedemo.R;
import com.zc.zby.basicframedemo.utils.AdapterViewUtil;
import com.zc.zby.basicframedemo.viewholder.FruitsViewHolder;

/**
 * Created by ${USER_NAME} on 2018/7/24.
 */
public class FruitsAdapter extends RecyclerArrayAdapter<String> {

    public FruitsAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        int[] itemLayouts = {R.layout.item_fruits, R.layout.item_blue_layout};
        View view = AdapterViewUtil.getItemLayouts(parent.getContext(), viewType, itemLayouts);
        return new FruitsViewHolder(view);
    }

    @Override
    public int getViewType(int position) {
        if (position % 20 == 0) {
            return 1;
        }
        return super.getViewType(position);
    }
}
