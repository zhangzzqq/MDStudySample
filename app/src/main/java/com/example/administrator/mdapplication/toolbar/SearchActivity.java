package com.example.administrator.mdapplication.toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.mdapplication.R;

/**
 * Created by steven on 2017/8/31.
 */

public class SearchActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{

    private SearchView searchView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
    }

    public static void startActivity(Context context ){
        Intent intent = new Intent(context, SearchActivity.class);
        context.startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        //设置搜索输入框的步骤
        //1.查找指定的MemuItem
        MenuItem menuItem = menu.findItem(R.id.action_search);
      /*  //2.设置SearchView v4 包方式
        View view = SearchViewCompat.newSearchView(this);
//        menuItem.setActionView(view);
        MenuItemCompat.setActionView(menuItem, view);*/
        //2.设置SearchView v7包方式
        View view = MenuItemCompat.getActionView(menuItem);
        if (view != null) {
            searchView = (SearchView) view;
            //4.设置SearchView 的查询回调接口
            searchView.setOnQueryTextListener(this);

            //在搜索输入框没有显示的时候 点击Action ,回调这个接口，并且显示输入框
//            searchView.setOnSearchClickListener();
            //当自动补全的内容被选中的时候回调接口
//            searchView.setOnSuggestionListener();
            //可以设置搜索的自动补全，或者实现搜索历史
//            searchView.setSuggestionsAdapter();

        }
        return true;
    }

    /**
     * 当用户在输入法中点击搜索按钮时,或者输入回车时,调用这个方法，发起实际的搜索功能
     * @param query
     * @return
     */
    @Override
    public boolean onQueryTextSubmit(String query) {
        Toast.makeText(SearchActivity.this, "Submit" + query, Toast.LENGTH_SHORT).show();
        searchView.clearFocus();
        return true;
    }
    /**
     * 每一次输入字符，都会调用这个方法，实现搜索的联想功能
     * @param newText
     * @return
     */
    @Override
    public boolean onQueryTextChange(String newText) {
        Toast.makeText(SearchActivity.this, "" + newText, Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public boolean deleteDatabase(String name) {

        return super.deleteDatabase(name);
    }


}
