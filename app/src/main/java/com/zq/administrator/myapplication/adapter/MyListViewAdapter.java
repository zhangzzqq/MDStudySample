package com.zq.administrator.myapplication.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;

import com.zq.administrator.mdapplication.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by steven on 2017/11/4 0004.
 *
 *
 *  clickFlag 通过这个变量记住那个item被点击，
 *  在通知listview重新加载布局，对其他item进行处理（有被选中的让它不选中）
 */

public class MyListViewAdapter extends BaseAdapter {
    private Context context;
    private List listData;
    private int clickFlag;
    private HashMap map = new HashMap();


    public MyListViewAdapter(Context context, List<String> data) {
        this.context = context;
        this.listData = data;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        final ViewHolder viewHolder;

        if (view == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.list_row,
                    null);

            viewHolder.checkedTextView = view
                    .findViewById(R.id.list_row_ctv);

            viewHolder.linearLayout = view
                    .findViewById(R.id.ll_layout);


            view.setTag(viewHolder);


        } else {

            viewHolder = (ViewHolder) view.getTag();
        }


        if (clickFlag != position) {

//            int pos = (int) map.get("position");
//            if (pos == position) {
//                viewHolder.checkedTextView.toggle();
//            }

            if (viewHolder.checkedTextView.isChecked()) {
                viewHolder.checkedTextView.toggle();
            }
        }

//        viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, "linearLayout被点击", Toast.LENGTH_SHORT).show();
//            }
//        });


        viewHolder.checkedTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                map.put("position", position);

                clickFlag = position;

                notifyDataSetChanged();

                viewHolder.checkedTextView.toggle();

                Log.w(MyListViewAdapter.class.getSimpleName(), "clickposition==" + position);
            }
        });

        Log.w(MyListViewAdapter.class.getSimpleName(), "position==" + position);
        return view;
    }


    static class ViewHolder {

        private CheckedTextView checkedTextView;
        private LinearLayout linearLayout;


    }


}
