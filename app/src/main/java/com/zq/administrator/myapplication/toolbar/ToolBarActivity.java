package com.zq.administrator.myapplication.toolbar;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.zq.administrator.mdapplication.R;

/**
 * 返回键导航主要操作如下：
 * <p>
 * 1、  返回键导航的显示与隐藏：setDisplayHomeAsUpEnabled(Boolean flag)
 * 2、  返回键导航的图标设置：setHomeAsUpIndicator
 * 3、  返回键的事件处理：重写onOptionsItemSelected方法，做如下判断
 * <p>
 * 返回按钮具体实现（添加Toolbar的返回按钮）
 * getSupportActionBar()
 * setDisplayHomeAsUpEnabled(true)
 * <p>
 * Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
 * setSupportActionBar(toolbar);
 * if(getSupportActionBar() != null)
 * // Enable the Up button
 * getSupportActionBar().setDisplayHomeAsUpEnabled(true);
 * }
 * 链接：http://www.jianshu.com/p/12570217636c
 *
 * http://www.jianshu.com/p/12570217636c
 *
 *
 */

public class ToolBarActivity extends AppCompatActivity {
    private Toolbar toolbar;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, ToolBarActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);

        initView();

        initData();

        initClick();
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);

    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    private void initData() {

        toolbar.setTitle("Title");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
//        toolbar.setSubtitle("SubTitle");
//        toolbar.setLogo(R.mipmap.ic_launcher);
        //设置导航图标要在setSupportActionBar方法之后
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //左边返回键
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            //可自定义返回键
//        getSupportActionBar().setHomeAsUpIndicator(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);
            //toolbar自带的标题可见
            actionBar.setDisplayShowTitleEnabled(true);

        }


    }


    /**
     * toolbar右边的菜单选项
     *
     * @param menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }


    private void initClick() {

        //菜单点击事件
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_search:
                        SearchActivity.startActivity(ToolBarActivity.this);
                        break;
                    case R.id.action_notifications:
                        Toast.makeText(ToolBarActivity.this, "Notificationa !", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_settings:
                        Toast.makeText(ToolBarActivity.this, "Settings !", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //点击back键finish当前activity
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }


}
