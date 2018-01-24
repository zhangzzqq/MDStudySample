package com.example.administrator.mdapplication.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.mdapplication.R;

/**
 * Created by steven on 2017/11/29 0029 .
 *
 * @Description:
 *   android:windowSoftInputMode="adjustPan" EditText是不可以滑动的，光标不会被软件挡住。对光标而言的，
 *   即总是可以卡看到输入的内容
 *
 *   android:windowSoftInputMode="adjustResize" EditText是可以滑动的 调整大小腾出空间让键盘可以显示
 *
 *   stateVisible 让键盘保持显示
 *
 *   stateHidden 保持隐藏
 *
 *   设置滚动条   android:scrollbars="vertical"
 *
 *   android:lines="3" 正好三行
 *   android:singleLine="true" 只会是一行，并且不会换行 。android:lines="1" 显示一行，会换行
 *      android:maxLines="1" 与android:lines="1" 一样的
 */

public class WindowSoftInputTest extends AppCompatActivity implements View.OnTouchListener {

    private EditText etText;
    private TextView tvScroll;

    public static void start(Context context) {

        Intent intent = new Intent(context, WindowSoftInputTest.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_window_soft_input);
        etText = (EditText) findViewById(R.id.et_text);
        etText.setOnTouchListener(this);
        tvScroll = (TextView) findViewById(R.id.tv_scroll);
        tvScroll.setMovementMethod(ScrollingMovementMethod.getInstance());

    }


    public void btnCloseWindowSoft(View View) {
        closeSoftKeybord();
    }

    public void btnOpenWindowSoft(View View) {
        showWindowSoft();
    }



    private void showWindowSoft() {
        InputMethodManager inputManager =
                (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.showSoftInput(etText, 0);
    }

    public void closeSoftKeybord() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(etText.getWindowToken(), 0);
    }


    @Override
    public boolean onTouch(View view, MotionEvent event) {
        etText.canScrollVertically(0);
        //触摸的是EditText并且当前EditText可以滚动则将事件交给EditText处理；否则将事件交由其父类处理
        if (view.getId() == R.id.et_text&&canVerticalScroll(etText)) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            if (event.getAction() == MotionEvent.ACTION_UP) {
                view.getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        return false;

    }


    /**
     * EditText竖直方向是否可以滚动
     * @param editText  需要判断的EditText
     * @return  true：可以滚动   false：不可以滚动
     */
    private boolean canVerticalScroll(EditText editText) {
        //滚动的距离
        int scrollY = editText.getScrollY();
        //控件内容的总高度
        int scrollRange = editText.getLayout().getHeight();
        //控件实际显示的高度
        int scrollExtent = editText.getHeight() - editText.getCompoundPaddingTop() -editText.getCompoundPaddingBottom();
        //控件内容总高度与实际显示高度的差值
        int scrollDifference = scrollRange - scrollExtent;

        if(scrollDifference == 0) {
            return false;
        }

        return (scrollY > 0) || (scrollY < scrollDifference - 1);
    }
}
