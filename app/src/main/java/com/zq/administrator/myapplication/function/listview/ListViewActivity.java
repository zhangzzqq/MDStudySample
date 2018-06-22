package com.zq.administrator.myapplication.function.listview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;

import com.zq.administrator.mdapplication.R;
import com.zq.administrator.myapplication.BaseActivity;
import com.zq.administrator.myapplication.adapter.ListDataAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by steven on 2018/6/8.
 */
public class ListViewActivity  extends BaseActivity{


    private ListView lv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list_view);

        initView();
        initData();

    }




    private void initView() {


        lv = findViewById(R.id.lv);

        ListDataAdapter listAdapter = new ListDataAdapter(this,getData());

        lv.setAdapter(listAdapter);


    }


    private void initData() {



    }



    private List<String> getData(){

        List list = new ArrayList();

        for(int i=0;i<16;i++){

            list.add("beautiful"+i);
        }

        return list;
    }
}
