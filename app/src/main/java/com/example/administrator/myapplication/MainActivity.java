package com.zq.administrator.mdapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.zq.administrator.mdapplication.activities.AndroidTest;
import com.zq.administrator.mdapplication.activities.AppBarLayoutActivity;
import com.zq.administrator.mdapplication.activities.BehaviorDependentActivity;
import com.zq.administrator.mdapplication.activities.BehaviorNestedActivity;
import com.zq.administrator.mdapplication.activities.BehaviorNestedExpandActivity;
import com.zq.administrator.mdapplication.activities.BottomNavigationActivity;
import com.example.administrator.myapplication.checkview.CheckedTextViewStudy;
import com.zq.administrator.mdapplication.activities.CustomPropertyStudy;
import com.zq.administrator.mdapplication.activities.FloatActionBarActivity;
import com.zq.administrator.mdapplication.activities.FragmentStudyTest;
import com.zq.administrator.mdapplication.activities.ImageButtonStudy;
import com.zq.administrator.mdapplication.activities.NestedScrollingActivity;
import com.zq.administrator.mdapplication.activities.SearchResultActivity;
import com.zq.administrator.mdapplication.activities.SpinnerStudy;
import com.zq.administrator.mdapplication.activities.TabFragmentActivityTest;
import com.zq.administrator.mdapplication.adapter.DataListAdapter;
import com.zq.administrator.mdapplication.constraintLayout.ConstraintLayoutActivity;
import com.zq.administrator.mdapplication.enumerate.EnumerateActivity;
import com.zq.administrator.mdapplication.gridlayoutstudy.GridLayoutStudy;
import com.zq.administrator.mdapplication.snackbar.SnackbarActivity;
import com.zq.administrator.mdapplication.tablayout.TabLayoutBottomActivity;
import com.zq.administrator.mdapplication.tablayout.TabLayoutTopActivity;
import com.zq.administrator.mdapplication.threadpool.ThreadPoolTest;
import com.zq.administrator.mdapplication.toolbar.ToolBarActivity;

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

        DataListAdapter adapter = new DataListAdapter(getData(), this);
        mList.setAdapter(adapter);
    }

    private void initClick() {

        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        AndroidTest.start(MainActivity.this);
                        break;
                    case 1:
                        TabLayoutTopActivity.startActivity(MainActivity.this);
                        break;
                    case 2:
                        TabLayoutBottomActivity.startActivity(MainActivity.this);
                        break;
                    case 3:
                        SnackbarActivity.startActivity(MainActivity.this);
                        break;
                    case 4:
                        FloatActionBarActivity.startActivity(MainActivity.this);
                        break;
                    case 5:
                        AppBarLayoutActivity.startActivity(MainActivity.this);
                        break;

                    case 6:
                        BehaviorDependentActivity.startActivity(MainActivity.this);
                        break;

                    case 7:
                        BehaviorNestedActivity.startActivity(MainActivity.this);
                        break;

                    case 8:
                        BehaviorNestedExpandActivity.startActivity(MainActivity.this);
                        break;

                    case 9:
                        SearchResultActivity.startActivity(MainActivity.this);
                        break;

                    case 10:
                        TextInputActivity.startActivity(MainActivity.this);
                        break;

                    case 11:
                        BottomNavigationActivity.startActivity(MainActivity.this);
                        break;

                    case 12:
                        SpinnerStudy.startActivity(MainActivity.this);
                        break;

                    case 13:
                        SwitchStudy.startActivity(MainActivity.this);
                        break;

                    case 14:
                        CheckedTextViewStudy.startActivity(MainActivity.this);
                        break;

                    case 15:
                        TextInputLayoutStudy.startActivity(MainActivity.this);
                        break;
                    case 16:
                        NestedScrollingActivity.startActivity(MainActivity.this);
                        break;

                    case 17:
                        ToolBarActivity.startActivity(MainActivity.this);
                        break;
                    case 18:
                        FragmentStudyTest.startActivity(MainActivity.this);
                        break;
                    case 19:
                        startActivity(new Intent(MainActivity.this, TabFragmentActivityTest.class));
                        break;
                    case 20:
                        startActivity(new Intent(MainActivity.this, EnumerateActivity.class));
                        break;
                    case 21:
                        startActivity(new Intent(MainActivity.this, ThreadPoolTest.class));
                        break;
                    case 22:
                        startActivity(new Intent(MainActivity.this, CustomPropertyStudy.class));
                        break;
                    case 23:
                        startActivity(new Intent(MainActivity.this, ImageButtonStudy.class));
                        break;
                    case 24:
                        startActivity(new Intent(MainActivity.this, ConstraintLayoutActivity.class));
                        break;
                        case 25:
                        startActivity(new Intent(MainActivity.this, GridLayoutStudy.class));
                        break;
                }
            }
        });
    }

    private List getData() {

        list.add("AndroidTest");
        list.add("tabLayoutTop");
        list.add("tabLayoutBottom");
        list.add("snackbar");
        list.add("floatActionBar");
        list.add("appBarLayout");
        list.add("behaviorDependent");
        list.add("behaviorNested");
        list.add("behaviorNestedExpand");
        list.add("searchResult");
        list.add("textInput");
        list.add("BottomNavigation");
        list.add("spinner");
        list.add("switch");
        list.add("checkedTextViewStudy");
        list.add("TextInputLayoutStudy");
        list.add("ScrollingActivityStudy");
        list.add("ToolBar");
        list.add("fragmentStudy");
        list.add("tabFragmentActivity");
        list.add("eenumerateActivity");
        list.add("threadPoolTest");
        list.add("customPropertyStudy");
        list.add("imageButtonStudy");
        list.add("constraintLayoutActivity");
        list.add("gridLayoutStudy");

        return list;

    }


}
