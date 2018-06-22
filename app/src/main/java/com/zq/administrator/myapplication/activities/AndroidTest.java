package com.zq.administrator.myapplication.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatCheckedTextView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zq.administrator.mdapplication.R;

public class AndroidTest extends AppCompatActivity {

    private EditText editText;
    private TextView tvThread;
    private Button btnToggle;
    private TextView tvTag;
    private EditText chatsView;
    private Button btnJson;
    private Button javatest;
    private String str = "姓名:朱锡浩1<br/>性别:女<br/>年龄:60岁<br/>过敏史:<br/>入科诊断:ds22,bbbb,cc,fsda,<br/>当前诊断:123213123<br/>VS目标值:瞳孔:12/22;";
    private TextView tvLine;
    private AppCompatCheckedTextView mAppCompatCheckedTextView;

    public static void start(Context context) {
        Intent intent = new Intent(context, AndroidTest.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editText = (EditText) findViewById(R.id.et);
        tvThread = (TextView) findViewById(R.id.tv_thread);
        btnToggle = (Button) findViewById(R.id.btn_toggle);
        tvTag = (TextView) findViewById(R.id.tv_tag);
        btnJson = (Button) findViewById(R.id.btn_json);
        javatest = (Button) findViewById(R.id.javatest);
        tvLine = (TextView) findViewById(R.id.tv_line);

        tvThread.setOnClickListener(clicks);
        btnToggle.setOnClickListener(clicks);
        tvTag.setOnClickListener(clicks);
        btnJson.setOnClickListener(clicks);
        javatest.setOnClickListener(clicks);


        setToMessage("123456");
        toJump();
//        tvLine.setText((str.replace("|","<br/>")));
        str = str.replace("<br/>", "\n");
        tvLine.setText(str);

//        btnJson.setSelected(true);
        hideSoftKeyBoard();
    }

    private void toJump() {

        findViewById(R.id.recyclerview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecyclerViewTest.start(AndroidTest.this);
            }
        });
    }

    public void setToMessage(String toPerson) {
        editText.setText(toPerson);
        //调整光标到倒数第二行
        editText.setSelection(toPerson.length() - 1);
    }


    View.OnClickListener clicks = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {

                case R.id.tv_thread:

//                    new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//
//                        }
//                    }).start();

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            tvThread.setText("54321");
                        }
                    }, 3000);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tvThread.setText("0000054321");
                        }
                    });
                    break;

                case R.id.btn_toggle:
                    Intent intent = new Intent(AndroidTest.this, ToggleActivity.class);
                    startActivity(intent);
                    break;

                case R.id.tv_tag:
                    String result = tvTag.getTag().toString();
                    Toast.makeText(AndroidTest.this, result, Toast.LENGTH_SHORT).show();
                    break;

                case R.id.btn_json:
                    parseData();
                    break;
                case R.id.javatest:
                    testData();
                    break;

            }
        }
    };

    private String result;
    private String strNewResult;

    private void testData() {

        result = "5/8/9";
        strNewResult = result.substring(1, result.length());
        System.out.println("strNewResult==" + strNewResult);
        Log.d(AndroidTest.class.getName(), "result==" + strNewResult);

    }

    private void parseData() {

        String strJson = "{\n" +
                "    \"resultCode\": 1000,\n" +
                "    \"message\": \"操作成功！\",\n" +
                "    \"data\": 1\n" +
                "}";

        PostNursingPlanRemindEntity entity = new Gson().fromJson(strJson, PostNursingPlanRemindEntity.class);
        Toast.makeText(AndroidTest.this, entity.getResultCode() + entity.getMessage(), Toast.LENGTH_SHORT).show();

        if (strJson != "") {

        }
    }


    public void btnImageView(View view) {
        Intent intent = new Intent(AndroidTest.this, ImageActivity.class);
        startActivity(intent);
    }

    private void hideSoftKeyBoard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0); //强制隐藏键盘
    }

    public void dialogTest(View view) {
        AlertDialogTest.start(view.getContext());
    }

    public void windowSoftInputTest(View view) {

        WindowSoftInputTest.start(view.getContext());
    }

    public void btn9png(View view) {
        startActivity(new Intent(AndroidTest.this, Png9Activity.class));
    }

    public void btnNullTest(View view) {

        startActivity(new Intent(AndroidTest.this, BtnNullTest.class));

    }

    public void editTest(View view) {

        startActivity(new Intent(AndroidTest.this, EditTestActivity.class));

    }

    public void tvNull(View view) {

       TextView textView = (TextView) findViewById(R.id.tv_null_text);
//        Person person = new Person("","");
//        String strResult = person.getEat();
//        Log.e(AndroidTest.class.getName(),"strResult=="+strResult);
//        textView.setText(person.getEat());

        String a ="1";
        String b =null;
        String c ="";
        if(a.equals(b)){
            textView.setText("a.equals.b");
        }

        if(a.equals(c)){
            textView.setText("a.equals.c");
        }

        if(!TextUtils.isEmpty(b)){
            Toast.makeText(AndroidTest.this,"非空",Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(AndroidTest.this,"空",Toast.LENGTH_SHORT).show();
                textView.setText(b);
        }

    }
    private Handler mHandler;//全局变量

    public void fileTest(View view){
        startActivity(new Intent(this, FileTest.class));

//            mHandler = new Handler();
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        Thread.sleep(1000);//在子线程有一段耗时操作,比如请求网络
//                        mHandler.post(new Runnable() {
//                            @Override
//                            public void run() {
//                                tvLine.setText("This is post");//更新UI
//                            }
//                        });
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }).start();

    }

    /**
     *
     * 实现功能：
     *
     *
     *
     * 注意事项：
     *
     * 可以通过Map 进行计算有那几个被勾选
     *
     * map.put(position,"checked")
     * map.put(position,"nochecked")
     * 然后去遍历map取出所需要的值
     *
     *
     * 或者通过  mAppCompatCheckedTextView.isChecked() 来进行判断
     *
     *
     */


    public void checkTextView(View view){

        mAppCompatCheckedTextView = (AppCompatCheckedTextView) findViewById(R.id.checkedTextView);

        mAppCompatCheckedTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AndroidTest.this, "点击", Toast.LENGTH_SHORT).show();
                if(!mAppCompatCheckedTextView.isChecked()){
                    mAppCompatCheckedTextView.setChecked(true);

                } else {
                    mAppCompatCheckedTextView.setChecked(false);

                }
            }
        });
    }

}
