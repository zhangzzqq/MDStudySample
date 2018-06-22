package com.zq.administrator.myapplication.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.zq.administrator.mdapplication.R;

/**
 * 网络请求，加载中dialog
 */
public class LoadingDialog extends Dialog {
    private TextView textView;
    private ProgressBar progressBar;

    public LoadingDialog(Context context) {
        this(context, R.style.Request_Dialog);

    }

    public LoadingDialog(Context context, int theme) {
        super(context, theme);
        setCanceledOnTouchOutside(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_loading_dialog);
        textView = (TextView) findViewById(R.id.textView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

    }

    //textView是空值
    public void setLoadingText(String text) {
         textView.setText(text);
    }

    public void toogleLoadingProgress(boolean show) {
        if (show) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

}
