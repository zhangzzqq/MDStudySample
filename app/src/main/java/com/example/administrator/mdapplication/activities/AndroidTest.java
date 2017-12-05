package com.example.administrator.mdapplication.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mdapplication.R;
import com.google.gson.Gson;

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

        startActivity(new Intent(AndroidTest.this, btnNullTest.class));

    }  public void editTest(View view) {

        startActivity(new Intent(AndroidTest.this, EditTestActivity.class));

    }


}
