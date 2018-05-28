package com.zq.administrator.myapplication;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.zq.administrator.mdapplication.R;
import com.zq.administrator.myapplication.utils.DialogUtils;


/**
 * Created by zq on 16/8/4.
 */
public class BaseActivity extends AppCompatActivity {

    public Context mContext;
    public Toolbar mToolbarTb;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);

        mContext = this;
        mToolbarTb = (Toolbar) findViewById(R.id.tb_toolbar);
        if (mToolbarTb != null) {
            setSupportActionBar(mToolbarTb);

            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        DialogUtils.insertDialog("标题","明天早上9:00开早会",this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);
        if (mToolbarTb != null) {
            mToolbarTb.setTitle(title);
        }
    }

}
