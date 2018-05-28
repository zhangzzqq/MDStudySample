package com.zq.administrator.myapplication.snackbar;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;

import com.zq.administrator.mdapplication.R;
import com.zq.administrator.mdapplication.utils.ToastUtils;
import com.zq.administrator.myapplication.BaseActivity;

/**
 * Created by steven on 17/10/29.
 */
public class SnackbarActivity extends BaseActivity {


    public static void startActivity(Context context ){
        Intent intent = new Intent(context, SnackbarActivity.class);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snackbar);

    }

    public void onClickDialog(View v) {
        new AlertDialog.Builder(this)
                .setTitle("Title")
                .setMessage("This is message")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create()
                .show();
    }

    public void onClickSnackbar(View v) {
        Snackbar.make(this.findViewById(android.R.id.content), "This is a Snackbar", Snackbar.LENGTH_SHORT)
                .setAction("Cancel", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                })
                .show();
    }

    public void onClickToast(View v) {
        ToastUtils.showToast(this, "This is a Toast");

    }

}
