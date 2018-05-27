package com.zq.administrator.mdapplication.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.zq.administrator.mdapplication.R;

/**
 * Created by steven on 2017/12/2 0002 .
 *
 * @Description: Android中.9图片的含义及制作教程
 * 参考链接 http://www.jianshu.com/p/3fd048644e3f
 * <p>
 * 遵守.9图制作规则
 * 左上 拉伸区域
 * 右下 内容区域
 * <p>
 * 在下边框和有边框表示内容被显示的区域，show content中可以看出来
 * 上边框和做边框表示可以拉伸的区域  Show patches
 */

public class Png9Activity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_png);
    }


}
