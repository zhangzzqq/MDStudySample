package com.example.administrator.mdapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.mdapplication.adapter.DataListAdapter;
import com.example.administrator.mdapplication.toolbar.ToolBarActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mList;
    private List list = new ArrayList();
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
        initClick();

    }

    private void initView() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }


    private void initData() {
        mList = (ListView) findViewById(R.id.listView);

        DataListAdapter adapter = new DataListAdapter(getData(),this);
        mList.setAdapter(adapter);
    }



    private void initClick() {

        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        ToolBarActivity.startActivity(MainActivity.this);
                        break;


                }
            }
        });
    }

    private List getData() {
        list.add("toolBar");
        return list;

    }


}
