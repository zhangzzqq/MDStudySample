package com.zq.administrator.myapplication.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.zq.administrator.myapplication.function.listview.ListViewActivity;

import java.util.List;

/**
 * Created by steven on 2018/6/8.
 */
public class ListDataAdapter extends BaseAdapter {


    private List list;

    public ListDataAdapter(ListViewActivity listViewActivity, List<String> data) {

        this.list = data;

    }


    public void setData(List lists){


    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return null;

    }


}
