package com.zq.administrator.myapplication.activities;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.zq.administrator.mdapplication.R;
import com.zq.administrator.mdapplication.adapter.MyAdapter;
import com.zq.administrator.myapplication.model.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by steven on 2017/11/4 0004.
 * <p>
 * <p>
 * 让spinner一开始不显示的写法
 * mSp_game_name.setOnItemSelectedListener(new OnItemSelectedListener() {
 *
 * @Override public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
 * if (b) {
 * // 主要功能代码；
 * view.setVisibility(View.INVISIBLE);
 * } else {
 * //获取到对象
 * PhotoEntity photoEntity = (PhotoEntity)mSp_game_name.getSelectedItem();
 * }
 * b = false;
 * <p>
 * }
 * @Override public void onNothingSelected(AdapterView<?> parent) {
 * // TODO Auto-generated method stub
 * <p>
 * }
 * });
 * 链接：http://www.jianshu.com/p/a7ab8d6471bb

 * spinner基本用法
 * http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2015/0105/2264.html
 *
 * theme主题不同，可能会影响标题栏的显示效果。。
 * eg:ActionBar标题栏中放入一个Spinner下拉菜单控件。
 * 当前Activity的theme主题必须为@android:style/Theme.Light"，
 * 才能保证Spinner下拉下来的列表不会覆盖在Spinner控件上。在此谨记
 * 设置Activity的主题为@android:style/Theme.Light是正常效果.所以可以用偏移量来解决这个问题
 *
 */

public class SpinnerStudy extends AppCompatActivity {


    private Spinner spinner;
    private Spinner spinner01;
    private static final String[] m = {"A型", "B型", "O型", "AB型", "其他"};

    public static void startActivity(Context context) {

        Intent intent = new Intent(context, SpinnerStudy.class);
        context.startActivity(intent);

    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_spinner);

        initView();
        initData();
        initClick();

    }


    private void initView() {

        spinner = (Spinner) findViewById(R.id.spinner1);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void initData() {

        //===============================方法1=====================================
        // 建立数据源
        String[] mItems2 = getResources().getStringArray(R.array.spinnername);
        // 建立Adapter并且绑定数据源
        ArrayAdapter<String> _Adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mItems2);
        //绑定 Adapter到控件
        _Adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        _Adapter2.setDropDownViewResource(R.layout.spinnerlayout);
        //spinnerMode=”dropdown”时，下拉的项目选择窗口在水平方向相对于Spinner窗口的偏移量。
        spinner.setDropDownHorizontalOffset(35);
        spinner.setDropDownVerticalOffset(40); //垂直
//        spinner.setDropDownWidth(120); //设置下拉列表的宽度

        spinner.setPopupBackgroundResource(R.color.gray);
        spinner.setAdapter(_Adapter2);
        spinner.setPrompt("品种");

        String [] mItems=null;
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mItems){


            @Override
            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                return super.getDropDownView(position, convertView, parent);
            }
        };
//===============================方法2=====================================

        spinner01 = (Spinner) findViewById(R.id.Spinner01);
        spinner01.setPrompt("血型");
        //将可选内容与ArrayAdapter连接起来
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, m);

        //设置下拉列表的风格
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //将adapter 添加到spinner中
        spinner01.setAdapter(adapter);

        //设置默认值
        spinner01.setVisibility(View.VISIBLE);


        //=================================方法3======================================

        // 初始化控件
        Spinner spinner3 = (Spinner) findViewById(R.id.Spinner03);
        // 建立数据源
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("张三", "上海 "));
        persons.add(new Person("李四", "上海 "));
        persons.add(new Person("王五", "北京"));
        persons.add(new Person("赵六", "广州 "));
        //  建立Adapter绑定数据源
        MyAdapter _MyAdapter = new MyAdapter(this, persons);
        //绑定Adapter
        spinner3.setAdapter(_MyAdapter);

    }


    private void initClick() {


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String[] remind = getResources().getStringArray(R.array.spinnername);

                Toast.makeText(SpinnerStudy.this, "" + remind[position], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //添加事件Spinner事件监听
        spinner01.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


}
