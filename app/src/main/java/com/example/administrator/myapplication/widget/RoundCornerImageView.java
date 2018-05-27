package com.zq.administrator.mdapplication.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

import com.zq.administrator.mdapplication.R;

/**
 * Created by steven on 2018/1/20.
 */

public class RoundCornerImageView extends View {

    private Paint paint;
    private Paint paint2;
    private int roundWidth;
    private int roundHeight;
    private TypedArray a;

    public RoundCornerImageView(Context context) {
        super(context);
        init(context, null);
    }

    public RoundCornerImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public RoundCornerImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            a = context.obtainStyledAttributes(attributeSet, R.styleable.RoundAngleImageView);
            assert a != null;
            roundWidth = a.getDimensionPixelSize(R.styleable.RoundAngleImageView_roundWidth, roundWidth);
            roundHeight = a.getDimensionPixelSize(R.styleable.RoundAngleImageView_roundHeight, roundHeight);
        } else {
            float density = context.getResources().getDisplayMetrics().density;
            roundWidth = (int) (roundWidth * density);
            roundHeight = (int) (roundHeight * density);
        }

        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setAntiAlias(true);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));

        paint2 = new Paint();
        paint2.setXfermode(null);
        a.recycle();//为了保持以后使用的一致性，需要回收
    }
}