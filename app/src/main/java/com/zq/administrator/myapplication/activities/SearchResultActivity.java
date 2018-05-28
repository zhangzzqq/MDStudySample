package com.zq.administrator.myapplication.activities;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.zq.administrator.mdapplication.R;
import com.zq.administrator.mdapplication.utils.ToastUtils;
import com.zq.administrator.myapplication.BaseActivity;


/**
 * Created by lxf on 16/10/28.
 *
 */

public class SearchResultActivity extends BaseActivity {


    public static void startActivity(Context context ){
        Intent intent = new Intent(context, SearchResultActivity.class);
        context.startActivity(intent);
    }



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        mToolbarTb.setTitle(R.string.search_result);

        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())){
            ToastUtils.showToast(this, intent.getStringExtra(SearchManager.QUERY));
        }
    }
}
