package com.example.administrator.mdapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.mdapplication.activities.AndroidTest;
import com.example.administrator.mdapplication.activities.AppBarLayoutActivity;
import com.example.administrator.mdapplication.activities.BehaviorDependentActivity;
import com.example.administrator.mdapplication.activities.BehaviorNestedActivity;
import com.example.administrator.mdapplication.activities.BehaviorNestedExpandActivity;
import com.example.administrator.mdapplication.activities.BottomNavigationActivity;
import com.example.administrator.mdapplication.activities.CheckedTextViewStudy;
import com.example.administrator.mdapplication.activities.CustomPropertyStudy;
import com.example.administrator.mdapplication.activities.FloatActionBarActivity;
import com.example.administrator.mdapplication.activities.FragmentStudyTest;
import com.example.administrator.mdapplication.activities.ImageButtonStudy;
import com.example.administrator.mdapplication.activities.NestedScrollingActivity;
import com.example.administrator.mdapplication.activities.SearchResultActivity;
import com.example.administrator.mdapplication.activities.SpinnerStudy;
import com.example.administrator.mdapplication.activities.TabFragmentActivityTest;
import com.example.administrator.mdapplication.adapter.DataListAdapter;
import com.example.administrator.mdapplication.constraintLayout.ConstraintLayoutActivity;
import com.example.administrator.mdapplication.enumerate.EnumerateActivity;
import com.example.administrator.mdapplication.snackbar.SnackbarActivity;
import com.example.administrator.mdapplication.tablayout.TabLayoutBottomActivity;
import com.example.administrator.mdapplication.tablayout.TabLayoutTopActivity;
import com.example.administrator.mdapplication.threadpool.ThreadPoolTest;
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

        return list;

    }


}
