package com.zq.administrator.myapplication.dialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.View;

import com.zq.administrator.mdapplication.R;
import com.zq.administrator.myapplication.BaseActivity;
import com.zq.administrator.myapplication.activities.AlertDialogTest;
import com.zq.administrator.myapplication.utils.DialogUtils;

/**
 * Created by steven on 2018/5/29.
 * <p>
 * https://developer.android.com/guide/topics/ui/dialogs?hl=zh-cn
 */
public class DialogStudy extends BaseActivity {

    private LoadingDialog loadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
    }


    public void button2(View view) {

//        showLoadingDialog("哈哈我来了.");
        showLoadingDialog();
    }

    public void button3(View view) {

        dismissLoadingDialog();
    }


    public void button4(View view) {
        startActivity(new Intent(this, AlertDialogTest.class));
    }

    public void button5(View view) {
//        DialogUtils.insertDialog("标题", "明天早上9:00开早会", this);
        DialogUtils.showDialogue(this);
    }


    public void button6(View view) {
        onClickDialogv7(view);
    }

    public void button7(View view) {
        onClickDialogapp(view);
    }

    public void button8(View view) {


        EaseAlertDialog dialog = new EaseAlertDialog(this, getString(R.string.readfire_message_title),
                "嗯嗯嗯嗯嗯嗯", null, new EaseAlertDialog.AlertDialogUser() {
            @Override
            public void onResult(boolean confirmed, Bundle bundle) {
            }
        }, false);
        // 设置触摸对话框外围不触发事件，防止误触碰
        dialog.setCanceledOnTouchOutside(false);
        // 这里是为了在不是点击OK按钮的情况下关闭对话框的操作
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {

            }
        });
        dialog.show();



    }

    public void button9(View view) {
        clearConversation();
    }


    /**
     * 进度条隐藏
     */
    public void dismissLoadingDialog() {

        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
    }

    /**
     * 进度条旋转
     */
    public void showLoadingDialog() {

        if (loadingDialog == null) {
            loadingDialog = new LoadingDialog(this);
        }
        if (!loadingDialog.isShowing()) {
            loadingDialog.show();
        }
    }

    /**
     * 进度条旋转
     */
    public void showLoadingDialog(String message) {

        if (loadingDialog == null) {
            loadingDialog = new LoadingDialog(this);
        }
        //在调用show()方法时候，会首先调用LoadingDialog类中的onCreate()方法
        if (!loadingDialog.isShowing()) {
            loadingDialog.show();
            loadingDialog.setLoadingText(message);
        }
    }


    /**
     * LoadingDialog里面的onCreate()方法中的textVIew会是空值 ，所以这样写会报空指针异常
     *
     * @param message
     */


    //"哈哈我来了."
    public void showDialog(String message) {
        if (loadingDialog == null) {
            loadingDialog = new LoadingDialog(this);

        }
        loadingDialog.setLoadingText(message);
        loadingDialog.toogleLoadingProgress(true);

    }


    public void onClickDialogv7(View v) {
        new AlertDialog.Builder(this)
                .setTitle("Title")
                .setMessage("This is message")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create()
                .show();
    }


    public void onClickDialogapp(View v) {
        new android.app.AlertDialog.Builder(this)
                .setTitle("Title")
                .setMessage("This is message")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create()
                .show();
    }



    public void clearConversation() {
        String st9 = getResources().getString(R.string.ok);
        new EaseAlertDialog(this, null, st9, null, new EaseAlertDialog.AlertDialogUser() {

            @Override
            public void onResult(boolean confirmed, Bundle bundle) {
                if (confirmed) {
                }
            }
        }, true).show();
    }




}

