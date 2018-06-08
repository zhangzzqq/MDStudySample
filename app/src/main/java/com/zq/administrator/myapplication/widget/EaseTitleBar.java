package com.zq.administrator.myapplication.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zq.administrator.mdapplication.R;

/**
 * Created by steven on 2018/6/8.
 */
public class EaseTitleBar extends RelativeLayout {

    protected RelativeLayout leftLayout;
    protected ImageView leftImage;
    protected TextView leftText;
    // 新增的阅后即焚开关按钮
    protected RelativeLayout fireLayout;
    protected ImageView fireImage;
    protected RelativeLayout rightLayout;
    protected ImageView rightImage;
    protected TextView titleView;
    protected RelativeLayout titleLayout;

    public EaseTitleBar(Context context, AttributeSet attrs, int defStyle) {
        this(context, attrs);
    }

    public EaseTitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public EaseTitleBar(Context context) {
        super(context);
        init(context, null);
    }

    private void init(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.ease_widget_title_bar, this);
        leftLayout = (RelativeLayout) findViewById(R.id.left_layout);
        leftImage = (ImageView) findViewById(R.id.left_image);
        leftText = (TextView) findViewById(R.id.left_text);
        fireLayout = (RelativeLayout) findViewById(R.id.fire_layout);
        fireImage = (ImageView) findViewById(R.id.fire_image);
        rightLayout = (RelativeLayout) findViewById(R.id.right_layout);
        rightImage = (ImageView) findViewById(R.id.right_image);
        titleView = (TextView) findViewById(R.id.title);
        titleLayout = (RelativeLayout) findViewById(R.id.root);

        parseStyle(context, attrs);
    }

    private void parseStyle(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.EaseTitleBar);
            String title = ta.getString(R.styleable.EaseTitleBar_titleBarTitle);
            titleView.setText(title);

            Drawable leftDrawable = ta.getDrawable(R.styleable.EaseTitleBar_titleBarLeftImage);
            if (null != leftDrawable) {
                leftImage.setImageDrawable(leftDrawable);
            }
            Drawable rightDrawable = ta.getDrawable(R.styleable.EaseTitleBar_titleBarRightImage);
            if (null != rightDrawable) {
                rightImage.setImageDrawable(rightDrawable);
            }

            Drawable background = ta.getDrawable(R.styleable.EaseTitleBar_titleBarBackground);
            if (null != background) {
                titleLayout.setBackgroundDrawable(background);
            }

            ta.recycle();
        }
    }

    public void setLeftImageResource(int resId) {
        leftImage.setImageResource(resId);
        leftText.setText("");
    }

    public void setLeftText(String text) {
        if (!TextUtils.isEmpty(text)) {
            leftImage.setVisibility(INVISIBLE);
            leftText.setText(text);
        } else {
            leftImage.setVisibility(VISIBLE);
            leftText.setText("");
        }
    }

    public void setRightImageResource(int resId) {
        rightImage.setImageResource(resId);
    }

    public void setLeftLayoutClickListener(View.OnClickListener listener) {
        leftLayout.setOnClickListener(listener);
    }

    // 设置阅后即焚开关按钮的点击事件
    public void setFireClickListener(View.OnClickListener listener) {
        fireLayout.setOnClickListener(listener);
    }

    // 设置阅后即焚开关按钮的资源图标
    public void setFireImageResource(int resId) {
        fireImage.setImageResource(resId);
    }

    public void closeReadFire() {
        fireImage.setVisibility(View.GONE);
    }

    public void setRightLayoutClickListener(View.OnClickListener listener) {
        rightLayout.setOnClickListener(listener);
    }

    public void setLeftLayoutVisibility(int visibility) {
        leftLayout.setVisibility(visibility);
    }

    public void setRightLayoutVisibility(int visibility) {
        rightLayout.setVisibility(visibility);
    }

    public void setTitle(String title) {
        titleView.setText(title);
    }

    public void setBackgroundColor(int color) {
        titleLayout.setBackgroundColor(color);
    }

    public void setBackgroundResource(int color) {
        titleLayout.setBackgroundResource(color);
    }


    public RelativeLayout getLeftLayout() {
        return leftLayout;
    }

    public RelativeLayout getRightLayout() {
        return rightLayout;
    }
}

