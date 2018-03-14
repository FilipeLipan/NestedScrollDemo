package com.example.lispa.nestedscrolldemo;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by lispa on 14/03/2018.
 */

public class Adapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public Adapter(List<String> data) {
        super(R.layout.list_group, data);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, String item) {
        viewHolder.setText(R.id.listTitle, item);

//        notifyItemRangeChanged(0,1);
    }

    public void reduce(){

    }
}