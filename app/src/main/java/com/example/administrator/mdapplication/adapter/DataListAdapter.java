package com.example.administrator.mdapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.mdapplication.activities.MainActivity;
import com.example.administrator.mdapplication.R;

import java.util.List;

/**
 * Created by Administrator on 2017/10/27 0027.
 */

public class DataListAdapter extends BaseAdapter {

    private List<String> listData;
    private Context mContext;

    public DataListAdapter(List data, MainActivity mainActivity) {

        this.listData = data;
        this.mContext = mainActivity;
    }

    @Override
    public int getCount() {

        return listData == null ? 0 : listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list, null);
            holder.textTitle = (TextView) convertView.findViewById(R.id.tv_title);
            //保存holder对象，让holder也参与循环
            convertView.setTag(holder);
        } else {
            //让holder也循环利用，减少findviewbyid
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textTitle.setText(listData.get(position));

        return convertView;
    }


    public static class ViewHolder {

        private TextView textTitle;


    }


}
