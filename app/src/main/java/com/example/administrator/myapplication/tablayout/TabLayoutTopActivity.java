package com.zq.administrator.mdapplication.tablayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import com.zq.administrator.mdapplication.BaseActivity;
import com.zq.administrator.mdapplication.R;
import com.zq.administrator.mdapplication.fragment.TabContentFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/29 0029.
 *
 *  当你的应用程序目标设为蜂巢平台时，你可以利用Action Bar部件提供的全部功能，将你的选项菜单项放在Action Bar的右上角，对用户来说使用更方便，控制该行为的主菜单项属性是android:showAsAction。
 　　这个属性可接受的值有：
 　　1、always：这个值会使菜单项一直显示在Action Bar上。
 　　2、ifRoom：如果有足够的空间，这个值会使菜单项显示在Action Bar上。
 　　3、never：这个值使菜单项永远都不出现在Action Bar上。
 　　4、withText：这个值使菜单项和它的图标，菜单文本一起显示。

 */

public class TabLayoutTopActivity extends BaseActivity {

    private TabLayout mTabTl;
    private ViewPager mContentVp;

    private List<String> tabIndicators;
    private List<Fragment> tabFragments;
    private ContentPagerAdapter contentAdapter;

    public static void startActivity(Context context ){
        Intent intent = new Intent(context, TabLayoutTopActivity.class);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tab_layout_top);

        mTabTl = (TabLayout) findViewById(R.id.tl_tab);
        mContentVp = (ViewPager) findViewById(R.id.vp_content);

        initContent();
        initTab();

    }


    private void initContent() {

        tabIndicators = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            tabIndicators.add("Tab " + i);
        }
        tabFragments = new ArrayList<>();
        for (String s : tabIndicators) {
            tabFragments.add(TabContentFragment.newInstance(s));
        }
        contentAdapter = new ContentPagerAdapter(getSupportFragmentManager());
        mContentVp.setAdapter(contentAdapter);

    }

    private void initTab(){

//        mTabTl.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTabTl.setTabMode(TabLayout.MODE_FIXED);
        mTabTl.setTabTextColors(ContextCompat.getColor(this, R.color.gray), ContextCompat.getColor(this, R.color.white));
        mTabTl.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.white));
        ViewCompat.setElevation(mTabTl, 10);//tablayout 阴影效果
        mTabTl.setupWithViewPager(mContentVp);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tab_layout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.tab_add:
                tabIndicators.add("Tab " + tabIndicators.size());
                tabFragments.add(TabContentFragment.newInstance(tabIndicators.get(tabIndicators.size()-1)));
                contentAdapter.notifyDataSetChanged();
                mTabTl.setupWithViewPager(mContentVp);
                return true;

            case R.id.tab_mode_fixed:
                mTabTl.setTabMode(TabLayout.MODE_FIXED);
                return true;

            case R.id.tab_mode_scrollable:
                mTabTl.setTabMode(TabLayout.MODE_SCROLLABLE);
                break;
        }
        return super.onOptionsItemSelected(item);
    }




    class ContentPagerAdapter extends FragmentPagerAdapter {

        public ContentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return tabFragments.get(position);
        }

        @Override
        public int getCount() {
            return tabIndicators.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabIndicators.get(position);
        }

    }

}
