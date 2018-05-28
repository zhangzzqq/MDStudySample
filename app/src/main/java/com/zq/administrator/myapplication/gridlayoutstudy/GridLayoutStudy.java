package com.zq.administrator.myapplication.gridlayoutstudy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.GridLayout;
import android.widget.Toast;

import com.zq.administrator.mdapplication.R;
import com.zq.administrator.myapplication.BaseActivity;

/**
 * Created by steven on 2018/5/25.
 */
public class GridLayoutStudy extends BaseActivity {


    private GridLayout gridLayout;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, GridLayoutStudy.class);
        context.startActivity(intent);

    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gridlayout5);

        gridLayout = findViewById(R.id.grid_type);


    }


    private Boolean initData() {

        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            View view = gridLayout.getChildAt(i);
            if (view != null && view instanceof CheckBox) {
                return ((CheckBox) view).isChecked();
            }
        }
        return false;
    }


    public void btnclick(View view){

        boolean a = initData();

        if (a) {
            Toast.makeText(GridLayoutStudy.this, "true", Toast.LENGTH_LONG).show();
        } else {

            Toast.makeText(GridLayoutStudy.this, "false", Toast.LENGTH_LONG).show();
        }


    }




}
