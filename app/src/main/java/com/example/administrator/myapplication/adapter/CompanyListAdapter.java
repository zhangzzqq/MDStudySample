package com.example.administrator.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;

import com.zq.administrator.mdapplication.R;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by steven on 2017/11/4 0004.
 */

public  class CompanyListAdapter extends BaseAdapter
{
    private ArrayList<com.personal.mdapplication.model.InsuranceCompany> riskArrayList;
    private HashMap checkedMap;
    private Context mContext;



    public ArrayList<com.personal.mdapplication.model.InsuranceCompany> getRiskArrayList()
    {
        return riskArrayList;
    }

    public CompanyListAdapter(ArrayList<com.personal.mdapplication.model.InsuranceCompany> regionArrayList, Context context)
    {
        this.riskArrayList = regionArrayList;
        checkedMap = new HashMap<>();
        this.mContext = context;
    }

    public void updateRefresh(ArrayList<com.personal.mdapplication.model.InsuranceCompany> refreshRegions)
    {
        if (riskArrayList == null)
        {
            riskArrayList = new ArrayList<>();
        }
        this.riskArrayList.clear();
        this.riskArrayList.addAll(refreshRegions);
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount()
    {
        if (riskArrayList == null)
            return 0;
        return riskArrayList.size();
    }

    @Override
    public Object getItem(int position)
    {
        return riskArrayList.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    class Holder
    {
        ImageView img_icon;

        CheckedTextView text_AreaName;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        Holder holder;
        if (convertView == null)
        {
            // android.R.layout.simple_list_item_checked
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_checktextview, null);
            holder = new Holder();
            holder.text_AreaName = (CheckedTextView)convertView.findViewById(R.id.checktv_title);
            holder.img_icon = (ImageView)convertView.findViewById(R.id.img_icon);
            convertView.setTag(holder);
        }
        else
        {
            holder = (Holder)convertView.getTag();
        }
        com.personal.mdapplication.model.InsuranceCompany region = riskArrayList.get(position);
        holder.text_AreaName.setText(region.name);

//        if (checkedMap.get(position) != null && checkedMap.get(position) == true)
        if (checkedMap.get(position) != null )
        {
            holder.text_AreaName.setChecked(true);
        }
        else
        {
            holder.text_AreaName.setChecked(false);
        }
        holder.text_AreaName.setOnClickListener(new View.OnClickListener()
        {

            @Override

            public void onClick(View v)
            {

                // TODO Auto-generated method stub

                CheckedTextView checkedTextView = (CheckedTextView)v;
                checkedTextView.toggle();
                checkedMap.put(position, checkedTextView.isChecked());

            }

        });

//        Glide.with(mContext).load("http://p4.so.qhimg.com/t01eead9be5f0a448de.jpg").into(holder.img_icon);
        // Glide.with(mContext).load(region.icon).into(holder.img_icon);
        return convertView;
    }
}
