package com.example.administrator.mdapplication.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Display;

import com.example.administrator.mdapplication.R;
import com.example.administrator.mdapplication.fragment.Fragment1;
import com.example.administrator.mdapplication.fragment.Fragment2;

/**
 * Created by steven on 2017/12/2 0002 .
 *
 * @Description: fragment 中有add hide replace
 * <p>
 * file:///E:/program%20file/androidAPI23/guide/components/fragments.html#Lifecycle
 * To make fragment transactions in your activity (such as add, remove, or replace a fragment), you must use APIs from FragmentTransaction. You can get an instance of FragmentTransaction from your Activity like this:
 * FragmentManager fragmentManager = getFragmentManager()
 * FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
 * You can then add a fragment using the add() method, specifying the fragment to add and the view in which to insert it. For example:
 * ExampleFragment fragment = new ExampleFragment();
 * fragmentTransaction.add(R.id.fragment_container, fragment);
 * fragmentTransaction.commit();
 * The first argument passed to add() is the ViewGroup in which the fragment should be placed, specified by resource ID, and the second parameter is the fragment to add.
 * Once you've made your changes with FragmentTransaction, you must call commit() for the changes to take effect.
 * 总结就是 add hide replace需要用到   getFragmentManager().beginTransaction().replace(R.id.main_layout, fragment1).commit();
 */

public class FragmentStudyTest extends BaseActivity {

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, FragmentStudyTest.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_fragment);
        setContentView(R.layout.activity_fragment_dynamic);
        Display display = getWindowManager().getDefaultDisplay();
        if (display.getWidth() > display.getHeight()) {
            Fragment1 fragment1 = new Fragment1();
            getFragmentManager().beginTransaction().replace(R.id.main_layout, fragment1).commit();
        } else {
            Fragment2 fragment2 = new Fragment2();
            getFragmentManager().beginTransaction().replace(R.id.main_layout, fragment2).commit();
        }
    }


}
