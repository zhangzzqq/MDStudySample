package com.zq.administrator.myapplication.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.zq.administrator.mdapplication.R;
import com.zq.administrator.myapplication.BaseActivity;

/**
 * Created by yifeng on 17/3/26.
 *
 */

public class BottomNavigationActivity extends BaseActivity {


    public static void startActivity(Context context ){
        Intent intent = new Intent(context, BottomNavigationActivity.class);
        context.startActivity(intent);
    }




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

//        BottomNavigationView view = (BottomNavigationView) findViewById(R.id.bnv_menu);
//        view.findViewById(R.id.action_explore).performClick();
    }
}
