package com.zc.zby.basicframedemo.viewholder;

import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.zc.zby.basicframedemo.R;

/**
 * Created by ${USER_NAME} on 2018/9/19.
 */
public class ImageWallViewHolder extends BaseViewHolder<String> {

    private final SimpleDraweeView simpleDraweeView;

    public ImageWallViewHolder(View itemView) {
        super(itemView);
        simpleDraweeView = $(R.id.simpleDraweeView);
    }

    @Override
    public void setData(String data) {
        super.setData(data);
        simpleDraweeView.setImageURI(data);
    }
}
