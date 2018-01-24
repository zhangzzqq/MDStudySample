package com.example.administrator.mdapplication.utils;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.text.TextUtils;

import com.example.administrator.mdapplication.BaseApplication;

import java.io.File;

/**
 * Created by Harrison.Pan on 2016/9/23.
 */
public class DeviceUtils {
    public DeviceUtils() {
    }

    public static String getCacheDir(String filePath) {
        String dir;
        if (isSdCardEnable()) {
            try {
                dir = BaseApplication.getContext().getExternalCacheDir().getAbsolutePath();
            } catch (NullPointerException var3) {
                dir = BaseApplication.getContext().getCacheDir().getAbsolutePath();
            }
        } else {
            dir = BaseApplication.getContext().getCacheDir().getAbsolutePath();
        }

        if (TextUtils.isEmpty(filePath)) {
            return dir;
        } else {
            if (filePath.startsWith(File.separator)) {
                dir = dir + filePath;
            } else {
                dir = dir + File.separator + filePath;
            }
            FileUtils.makeDirs(dir);
            return dir;
        }
    }
    //   dir = BaseApplication.getContext().getExternalFilesDir("").getAbsolutePath();
///storage/emulated/0/Android/data/com.example.administrator.mdapplication/files
    public static String getFileDir(String filePath) {
        String dir;
        if (isSdCardEnable() && BaseApplication.getContext().getExternalFilesDir("") != null) {
            dir = BaseApplication.getContext().getExternalFilesDir("").getAbsolutePath();
        } else {
            dir = BaseApplication.getContext().getFilesDir().getAbsolutePath();
        }

        if (TextUtils.isEmpty(filePath)) {
            return dir;
        } else {
            if (filePath.startsWith(File.separator)) {
                dir = dir + filePath;
            } else {
                dir = dir + File.separator + filePath;
            }

            FileUtils.makeDirs(dir);
            return dir;
        }
    }

    public static boolean isSdCardEnable() {
        return "mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable();
    }

    public static int getAppVersion() {
        try {
            PackageInfo e = BaseApplication.getContext().getPackageManager().getPackageInfo(BaseApplication.getContext().getPackageName(), 0);
            return e.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 1;
        }
    }

    public static boolean isApkDebugable() {
        try {
            ApplicationInfo e = BaseApplication.getContext().getApplicationInfo();
            return (e.flags & 2) != 0;
        } catch (Exception e) {
//            log.e(e.getMessage());
            return false;
        }
    }
}
