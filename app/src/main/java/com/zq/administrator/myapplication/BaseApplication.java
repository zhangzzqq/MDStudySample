package com.zq.administrator.myapplication;

import android.app.Application;
import android.content.Context;

import com.zq.administrator.myapplication.utils.DialogUtils;

/**
 * Created by steven on 2018/1/9.
 */

public class BaseApplication extends Application {

    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        this.context = getApplicationContext();





    }
    public static Context getContext(){
        return context;
    }


}
