package com.zq.administrator.myapplication.activities;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.zq.administrator.mdapplication.R;

import java.util.List;

/**
 * Created by steven on 2017/9/24.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder > {

    private List list;
    //item类型
    public static final int ITEM_TYPE_HEADER = 0;
    public static final int ITEM_TYPE_CONTENT = 1;
    public static final int ITEM_TYPE_BOTTOM = 2;
    private int mHeaderCount = 1;//头部View个数
    private int mBottomCount = 1;//底部View个数


    public RecyclerAdapter(List<String> list) {
        this.list = list;
    }

    //判断当前item是否是HeadView
    public boolean isHeaderView(int position) {
        return mHeaderCount != 0 && position < mHeaderCount;
    }

    //判断当前item是否是FooterView
    public boolean isBottomView(int position) {
        return mBottomCount != 0 && position >= (mHeaderCount + list.size());
    }

    //判断当前item类型
    @Override
    public int getItemViewType(int position) {
        int dataItemCount = list.size();
        if (mHeaderCount != 0 && position < mHeaderCount) {
        //头部View
            return ITEM_TYPE_HEADER;
        } else if (mBottomCount != 0 && position >= (mHeaderCount + dataItemCount)) {
        //底部View
            return ITEM_TYPE_BOTTOM;
        } else {
            //内容View
            return ITEM_TYPE_CONTENT;
        }
    }

    //头部 ViewHolder
    public static class HeaderViewHolder extends RecyclerView.ViewHolder {
        public HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }
    //底部 ViewHolder
    public static class BottomViewHolder extends RecyclerView.ViewHolder {
        public BottomViewHolder(View itemView) {
            super(itemView);
        }
    }


    @Override
    public RecyclerView.ViewHolder  onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType ==ITEM_TYPE_HEADER) {
            return new HeaderViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_header, parent, false));
        } else if (viewType == ITEM_TYPE_CONTENT) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
            return new Holder(view);
        } else if (viewType == ITEM_TYPE_BOTTOM) {
            return new BottomViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_footer, parent, false));
        }
        return null;
    }

    /**
     *
     * @param holder
     * @param position
     *
     *
     *  onBindViewHolder positon 0 1 2....12
     *
     * list position 0 1 2 ...10
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder  holder, final int position) {

        if (holder instanceof HeaderViewHolder) {

        } else if (holder instanceof Holder) {
            Holder holderNormal = (Holder) holder;
            if(position>10){
                return;
            }
            holderNormal.tv.setText(list.get(position) + "");

//            if(position>10){
//                holderNormal.tv.setText("position>10");
//            }else {
//                holderNormal.tv.setText(list.get(position) + "");
//            }
            holderNormal.cardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "position==" + position, Toast.LENGTH_SHORT).show();
                }
            });
        } else if (holder instanceof BottomViewHolder) {

        }

    }

        @Override
    public int getItemCount() {
            int a = mHeaderCount + list.size() + mBottomCount;
            Log.d("a","a==="+a);
        return mHeaderCount + list.size() + mBottomCount;
    }

    class Holder extends RecyclerView.ViewHolder {

        public final View view;
        public TextView tv;
        public CardView cardview;

        public Holder(View itemView) {
            super(itemView);
            view = itemView;
            tv = (TextView) view.findViewById(R.id.tv);
            cardview = (CardView) view.findViewById(R.id.cardview);
        }

    }


}
