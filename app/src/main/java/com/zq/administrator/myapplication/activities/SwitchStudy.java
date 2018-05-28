package com.zq.administrator.myapplication.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zq.administrator.mdapplication.R;

/**
 * Created by steven on 2017/11/4 0004.
 */

public class SwitchStudy extends AppCompatActivity {


    public static void startActivity(Context context) {

        Intent intent = new Intent(context, SwitchStudy.class);
        context.startActivity(intent);

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_switch);
    }
}
