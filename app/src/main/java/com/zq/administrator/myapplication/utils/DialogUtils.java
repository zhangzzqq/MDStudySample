package com.zq.administrator.myapplication.utils;

import android.content.Context;
import android.support.v7.app.AlertDialog;

/**
 * Created by steven on 2018/5/27.
 */
public class DialogUtils {


    public static void insertDialog(String title, String message, Context context){


        AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(context);

        alertDialogBuilder.setMessage(title);
        alertDialogBuilder.setMessage(message);


        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();//将dialog显示出来

    }



}
