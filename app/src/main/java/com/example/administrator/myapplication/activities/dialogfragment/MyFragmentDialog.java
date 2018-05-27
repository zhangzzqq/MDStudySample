package com.example.administrator.myapplication.activities.dialogfragment;

import android.view.View;
import android.widget.Button;

import com.zq.administrator.mdapplication.R;

import butterknife.BindView;

/**
 * Created by steven on 2018/1/18.
 */

public class MyFragmentDialog extends com.zq.administrator.mdapplication.activities.dialogfragment.DialogFragmentStudy {

    @BindView(R.id.btn_test)
    Button mBtnTest;

    @Override
    protected double[] getWindowSize() {
        return new double[]{0.5, 0.5};
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_fragment_test;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setListener() {
        mBtnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyFragmentDialog.this.dismiss();
            }
        });
    }
}