package com.zq.administrator.mdapplication.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.zq.administrator.mdapplication.R;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by steven on 2017/9/24.
 */

public class RecyclerViewTest extends AppCompatActivity {


    private RecyclerView recycler;
    private RecyclerAdapter recyclerAdapter;
    private List<String> list = new ArrayList<>();
    private int[] b = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};




    public static void start(Context mainActivity) {
        Intent intent = new Intent(mainActivity, RecyclerViewTest.class);
        mainActivity.startActivity(intent);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.recycler);

        recycler = (RecyclerView) findViewById(R.id.recycler);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(mLayoutManager);
        // 设置Item添加和移除的动画
        recycler.setItemAnimator(new DefaultItemAnimator());
        recyclerAdapter = new RecyclerAdapter(list);
        recycler.setAdapter(recyclerAdapter);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                addData();
            }
        }, 50);

        findViewById(R.id.add).setOnClickListener(clicks);
        findViewById(R.id.delete).setOnClickListener(clicks);


    }

    private void addData() {
        for (int a : b) {
            list.add(a + "data");
        }
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
          String a = (String) iterator.next();
            Log.d("data","data=="+a);
        }
        recyclerAdapter.notifyDataSetChanged();
    }

//adapter.notifyItemRangeChanged(position, data.size() - position);
    private View.OnClickListener clicks = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
//                mList.add(2,"插入"+count);
//                mAdapter.notifyItemInserted(2);
//                mAdapter.notifyItemRangeChanged(2,mList.size()-2);
                case R.id.add:
                    list.add(1, "add data1");
                    recyclerAdapter.notifyItemInserted(1);
                    recyclerAdapter.notifyItemRangeChanged(1, list.size()-1);
                    break;
                case R.id.delete:
                    list.remove(1);
                    recyclerAdapter.notifyItemRemoved(1);
                    recyclerAdapter.notifyItemRangeChanged(1, list.size()-1);
                    break;


            }
        }
    };


}
