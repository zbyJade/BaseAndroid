package com.zc.zby.basicframedemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.zc.zby.basicframedemo.R;
import com.zc.zby.basicframedemo.utils.AdapterViewUtil;
import com.zc.zby.basicframedemo.viewholder.ShopsViewHolder;

/**
 * Created by ${USER_NAME} on 2018/9/17.
 */
public class ShopsAdapter extends RecyclerArrayAdapter<String> {

    public ShopsAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        View view = AdapterViewUtil.getItemLayouts(parent.getContext(), viewType, R.layout.item_shops);
        return new ShopsViewHolder(view);
    }
}
