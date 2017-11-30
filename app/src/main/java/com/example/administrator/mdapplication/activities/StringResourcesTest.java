package com.example.administrator.mdapplication.activities;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.mdapplication.R;

public class StringResourcesTest extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources);

        tv = (TextView) findViewById(R.id.textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * 清空按钮Click事件。
     * @param v
     */
    public void clearFunction(View v){
        tv.setText("");
    }

    /**
     * 测试字符串资源
     * @param v
     */
    public void testStringFunction(View v){
        StringBuffer sbf = new StringBuffer();
        String simple_string = getString(R.string.simple_string);
        sbf.append("getString(simple_string):" + simple_string + "\n");
//		CharSequence _simple_string = getText(R.string.simple_string);
//		sbf.append("getText(simple_string):" + _simple_string + "\n");

        String single_quoted_string = getString(R.string.single_quoted_string);
        sbf.append("getString(single_quoted_string):" + single_quoted_string + "\n");
//		CharSequence _single_quoted_string = getText(R.string.single_quoted_string);
//		sbf.append("getText(single_quoted_string):" + _single_quoted_string + "\n");

        String single_quoted_string2 = getString(R.string.single_quoted_string2);
        sbf.append("getString(single_quoted_string2):" + single_quoted_string2 + "\n");
//		CharSequence _single_quoted_string2 = getText(R.string.single_quoted_string2);
//		sbf.append("getText(single_quoted_string2):" + _single_quoted_string2 + "\n");

        String double_quoted_string = getString(R.string.double_quoted_string);
        sbf.append("getString(double_quoted_string):" + double_quoted_string + "\n");
//		CharSequence _double_quoted_string = getText(R.string.double_quoted_string);
//		sbf.append("getText(double_quoted_string):" + _double_quoted_string + "\n");

        String double_quoted_string2 = getString(R.string.double_quoted_string2);
        sbf.append("getString(double_quoted_string):" + double_quoted_string2 + "\n");
//		CharSequence _double_quoted_string2 = getText(R.string.double_quoted_string2);
//		sbf.append("getText(double_quoted_string):" + _double_quoted_string2 + "\n");

        String format_string = getString(R.string.format_string, "Superman", 20);
        sbf.append("getString(format_string):" + format_string + "\n");

        String tagged_string = getString(R.string.tagged_string3);
        sbf.append("getString(tagged_string):" + tagged_string + "\n");
        sbf.append(Html.fromHtml(tagged_string) + "\n");
        CharSequence _tagged_string = getText(R.string.tagged_string3);
        sbf.append("getText(tagged_string):" + _tagged_string + "\n");

        tv.setText(sbf.toString());
    }

    /**
     * 测试string-array资源。
     * @param v
     */
    public void testStringArrayFunction(View v){
        StringBuffer sbf = new StringBuffer();
        Resources res = getResources();
        String[] stringArray = res.getStringArray(R.array.test_array);
        for (String str : stringArray) {
            sbf.append(str);
            sbf.append("\n");
        }
        tv.setText(sbf.toString());
    }

    /**
     * 带HTML标签的字符串。
     * @param v
     */
    public void htmlStrFunction(View v){
//		String tagged_string = getString(R.string.tagged_string1);
//		String tagged_string = getString(R.string.tagged_string2);
        String tagged_string = getString(R.string.tagged_string3);
//		tv.setText(tagged_string);
        tv.setText(Html.fromHtml(tagged_string));
//		tv.setText(Html.fromHtml(getText(R.string.tagged_string2).toString()));

//		tv.setText(getText(R.string.tagged_string1));
//		tv.setText(getText(R.string.tagged_string2));
//		tv.setText(getText(R.string.tagged_string3));
    }

    /**
     * 测试带HTML标签和格式化的字符串。
     * @param v
     */
    public void formatTaggedFunction(View v){
//		String tagged_string = getString(R.string.format_tagged_string);
//		String formatStr = String.format(tagged_string, "superman", 25);
//		tv.setText(formatStr);

        String escapedUsername = TextUtils.htmlEncode("superman <");

        String tagged_string = getString(R.string.format_tagged_string);
        String formatStr = String.format(tagged_string, escapedUsername, 25);
        tv.setText(Html.fromHtml(formatStr));
    }

    /**
     * 测试plural资源。
     * @param v
     */
    public void pluralFunction(View v){
        Resources res = getResources();
        String s0 = res.getQuantityString(R.plurals.test_plurals, 0);
        String s1 = res.getQuantityString(R.plurals.test_plurals, 1);
        String s2 = res.getQuantityString(R.plurals.test_plurals, 2);
        String s3 = res.getQuantityString(R.plurals.test_plurals, 3);
        tv.setText(s0 + "\n" + s1 + "\n" + s2 + "\n" + s3);
    }


}
