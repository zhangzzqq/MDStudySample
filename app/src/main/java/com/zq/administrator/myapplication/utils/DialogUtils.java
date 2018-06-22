package com.zq.administrator.myapplication.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.zq.administrator.myapplication.BaseApplication;

/**
 * Created by steven on 2018/5/27.
 */
public class DialogUtils {


    public static void insertDialog(String title, String message, Context context){
        AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(context);
        alertDialogBuilder.setTitle(title);
        alertDialogBuilder.setMessage(message);
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();//将dialog显示出来

    }



    public static void  showDialogue (Activity activity) {


    }


    /**
     *
     * 自定义对话框
     *
     *
     * 自定义对话框需要  dialog = builder.create();来创建
     */


   public void dialogCustom(){

//       AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//       dialog = builder.create();
//       //将自定义的布局设置给AlertDialog
//       View view = View.inflate(UiUtils.getContext(), R.layout.updategroup, null);
//       dialog.setView(view);
//       //获取布局中的按钮并设置这个自定义布局的监听
//       Button button = (Button) view.findViewById(R.id.update_ok);
//       final EditText editText = (EditText) view.findViewById(R.id.new_group_name);
//       button.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View view) {
//               //自定义布局中按钮的点击事件
//           }
//       });
//       //i显示自定义布局对话框
//       dialog.show();
   }


}
