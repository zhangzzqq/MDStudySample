package com.zq.administrator.myapplication.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.zq.administrator.mdapplication.R;
import com.zq.administrator.myapplication.BaseActivity;

/**
 * Created by steven on 2017/11/5 0005.
 * <p>
 * scroll:将此布局和滚动时间关联。这个标识要设置在其他标识之前，
 * 没有这个标识则布局不会滚动且其他标识设置无效。
 * enterAlways:任何向下滚动操作都会使此布局可见。这个标识通常被称为“快速返回”模式。
 * enterAlwaysCollapsed：假设你定义了一个最小高度（minHeight）同时enterAlways也定义了，
 * 那么view将在到达这个最小高度的时候开始显示，并且从这个时候开始慢慢展开，当滚动到顶部的时候展开完。
 * exitUntilCollapsed：当你定义了一个minHeight，此布局将在滚动到达这个最小高度的时候折叠。
 * snap:当一个滚动事件结束，如果视图是部分可见的，那么它将被滚动到收缩或展开。
 * 例如，如果视图只有底部25%显示，它将折叠。相反，如果它的底部75%可见，那么它将完全展开。
 * <p>
 * 链接：http://www.jianshu.com/p/06c0ae8d9a96
 * github
 * https://github.com/Bilibili/DanmakuFlameMaster
 * <p>
 * <p>
 * AppBarLayout是一种支持响应滚动手势的app bar布局（比如工具栏滚出或滚入屏幕），
 * CollapsingToolbarLayout则是专门用来实现子布局内不同元素响应滚动细节的布局。
 *
 * CollapsingToolbarLayout和ScrollView一起使用会有滑动bug，注意要使用NestedScrollView来替代ScrollView。
 */

public class NestedScrollingActivity extends BaseActivity {


    public static void startActivity(Context context) {

        Intent intent = new Intent(context, NestedScrollingActivity.class);
        context.startActivity(intent);

    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_scrollingview);

    }


}
