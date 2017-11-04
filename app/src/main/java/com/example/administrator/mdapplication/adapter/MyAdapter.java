package com.example.administrator.mdapplication.adapter;

/**
 * Created by steven on 2017/11/4 0004.
 */

import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.mdapplication.R;

import model.Person;

/**
 * 自定义适配器类
 * @author jiangqq  <a href=http://blog.csdn.net/jiangqq781931404></a>
 *
 */
public class MyAdapter extends BaseAdapter {
    private List<Person> mList;
    private Context mContext;

    public MyAdapter(Context pContext, List<Person> pList) {
        this.mContext = pContext;
        this.mList = pList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    /**
     * 下面是重要代码
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater _LayoutInflater=LayoutInflater.from(mContext);
        convertView=_LayoutInflater.inflate(R.layout.item_custom, null);
        if(convertView!=null) {
            ImageView imageView = (ImageView)convertView.findViewById(R.id.image);
            imageView.setImageResource(R.mipmap.ic_launcher);
            TextView _TextView1=(TextView)convertView.findViewById(R.id.textView1);
            TextView _TextView2=(TextView)convertView.findViewById(R.id.textView2);
            _TextView1.setText(mList.get(position).getPersonName());
            _TextView2.setText(mList.get(position).getPersonAddress());
        }
        return convertView;
    }
}
