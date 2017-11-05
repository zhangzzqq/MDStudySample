package com.example.administrator.mdapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;

import com.example.administrator.mdapplication.R;

/**
 * Created by steven on 2017/11/4 0004.
 */

public class MyListViewAdapter extends BaseAdapter {
    private Context context;

    public MyListViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int arg0) {
        return arg0;
    }

    @Override
    public long getItemId(int arg0) {
        return arg0;
    }

    @Override
    public View getView(int position, View arg1, ViewGroup viewGroup) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_row,
                null);
        final CheckedTextView ctv = (CheckedTextView) view
                .findViewById(R.id.list_row_ctv);
        ctv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ctv.toggle();// 反转
            }
        });
        return view;
    }

}
