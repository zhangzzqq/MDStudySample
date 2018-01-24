package com.example.administrator.mdapplication.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.administrator.mdapplication.R;


/**
 * Created by steven on 2017/11/1 0001.
 */

public class ToggleActivity extends com.example.administrator.mdapplication.BaseActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.toggle_button);


        com.suke.widget.SwitchButton switchButton = (com.suke.widget.SwitchButton)
                findViewById(R.id.switch_button);


    }
}
