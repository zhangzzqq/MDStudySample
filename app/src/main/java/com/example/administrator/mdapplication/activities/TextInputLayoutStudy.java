package com.example.administrator.mdapplication.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;

import com.example.administrator.mdapplication.R;

/**
 * Created by steven on 2017/11/5 0005.
 *
 * TextInputLayoutStudy 参考链接地址
 * http://www.jianshu.com/p/2ea0338978e6
 *
 * 布局xmel属性 http://deep-fish.iteye.com/blog/2015228
 *
 * app:counterOverflowTextAppearance 计数超过最大长度时显示的文本样式
 * android:scrollbarAlwaysDrawHorizontalTrack	 设置组件是否总是显示水平滚动条的轨迹 （在布局中删除没有看出来有什么差别）
 *
 * app:passwordToggleEnabled 控制是否显示密码可见切换图标
  代码对应方法：setPasswordVisibilityToggleEnabled(boolean)


 */

public class TextInputLayoutStudy extends BaseActivity {


    private TextInputLayout mTextInputLayoutUser;
    private TextInputLayout mTextInputLayoutPassword;
    private TextInputEditText mInputEditTextPassword;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, TextInputLayoutStudy.class);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_text_input_layout);

        initData();


    }


    private void initData() {
//=====================================最大输入字符数==================================================
        mTextInputLayoutUser = (TextInputLayout) findViewById(R.id.text_input_layout_user);
        //设置可以计数 ，但是计数只是在超过的时候才显示出来
        mTextInputLayoutUser.setCounterEnabled(true);
        //计数的最大值
        mTextInputLayoutUser.setCounterMaxLength(20);

//=====================================密码输入错误信息提示==================================================
        mTextInputLayoutPassword = (TextInputLayout) findViewById(R.id.text_input_layout_password);
        mInputEditTextPassword = (TextInputEditText) findViewById(R.id.text_input_password);

        mInputEditTextPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //当密码不正确的时候，显示错误提示，当内容发生变幻的时候，记得调用
                mTextInputLayoutPassword.setErrorEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

  //========================手机号码或者用户输入错误的提示信息=============================================

//        mInputEditTextUser.setError("格式不正确");
//或者
//        mInputEditTextUser.setError("格式不正确",getDrawable(R.drawable.activity_close));



        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = mInputEditTextPassword.getText().toString();
                if(TextUtils.isEmpty(password)||password.length()<6){
                    mTextInputLayoutPassword.setError("密码错误不能少于6个字符");
                }

            }
        });




    }


}
