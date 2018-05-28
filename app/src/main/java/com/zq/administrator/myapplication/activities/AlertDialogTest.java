package com.zq.administrator.myapplication.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.zq.administrator.mdapplication.R;

/**
 * Created by steven on 2017/11/29 0029 .
 *
 * @Description:
 */

public class AlertDialogTest  extends AppCompatActivity{


    public static void start(Context context){
        Intent intent = new Intent(context,AlertDialogTest.class);
        context.startActivity(intent);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_alert_dialog);

        initView();
        initData();

    }

    private void initView() {

    }

    private void initData() {
        showOneDialog("testtesttest","");
    }

    private void showOneDialog(String desc, final String downloadurl) {
        final AlertDialog build = new AlertDialog.Builder(this).create();
        //自定义布局
        View view = getLayoutInflater().inflate(R.layout.custom_dialog, null);
        //把自定义的布局设置到dialog中，注意，布局设置一定要在show之前。从第二个参数分别填充内容与边框之间左、上、右、下、的像素
        build.setView(view, 0, 0, 0, 0);
        //一定要先show出来再设置dialog的参数，不然就不会改变dialog的大小了
        build.show();
        //得到当前显示设备的宽度，单位是像素
        int width = getWindowManager().getDefaultDisplay().getWidth();
        //得到这个dialog界面的参数对象
        WindowManager.LayoutParams params = build.getWindow().getAttributes();
        //设置dialog的界面宽度
        params.width = width - (width / 6);
        //设置dialog高度为包裹内容
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        //设置dialog的重心
        params.gravity = Gravity.CENTER;
        //dialog.getWindow().setLayout(width-(width/6), LayoutParams.WRAP_CONTENT);
        //用这个方法设置dialog大小也可以，但是这个方法不能设置重心之类的参数，推荐用Attributes设置
        //最后把这个参数对象设置进去，即与dialog绑定
        build.getWindow().setAttributes(params);
        Button leftButton = (Button) view.findViewById(R.id.splash_dialog_left);
        Button rightButton = (Button) view.findViewById(R.id.splash_dialog_right);
        TextView warnMessage = (TextView) view.findViewById(R.id.warnmessage);
        warnMessage.setText(desc);
        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                downloadApk(downloadurl);
                build.dismiss();
            }
        });
        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                build.dismiss();
//                loadMainActivity();
            }
        });
    }
}
