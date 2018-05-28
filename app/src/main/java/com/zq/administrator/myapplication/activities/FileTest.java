package com.zq.administrator.myapplication.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;

import com.zq.administrator.mdapplication.R;
import com.zq.administrator.myapplication.BaseActivity;
import com.zq.administrator.myapplication.utils.DeviceUtils;
import com.zq.administrator.myapplication.utils.FileUtils;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.io.File;

/**
 * Created by steven on 2018/1/9.
 */

public class FileTest extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_file_test);
    }


    public void btnWrite(View view){

        String crashFileName = "crash_" + DateFormatUtils.format(System.currentTimeMillis(), "yyyyMMddHHmmss") + ".log";
        FileUtils.writeFile(DeviceUtils.getFileDir(File.separator + "log" + File.separator) + crashFileName, "123", false);

    }


    public String getFileDir(String filePath) {
        String dir;
        if( getExternalFilesDir("") != null) {
            dir = getExternalFilesDir("").getAbsolutePath();
        } else {
            dir = getFilesDir().getAbsolutePath();
        }

        if(TextUtils.isEmpty(filePath)) {
            return dir;
        } else {
            if(filePath.startsWith(File.separator)) {
                dir = dir + filePath;
            } else {
                dir = dir + File.separator + filePath;
            }

            FileUtils.makeDirs(dir);
            return dir;
        }
    }
}
