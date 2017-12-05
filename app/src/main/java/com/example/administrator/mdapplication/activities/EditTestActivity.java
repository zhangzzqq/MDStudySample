package com.example.administrator.mdapplication.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.mdapplication.R;

/**
 * Created by steven on 2017/12/5 0005 .
 *
 * @Description:
 */

public class EditTestActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_edittext_text);
        final String result ;
      EditText editText = (EditText) findViewById(R.id.et);

          editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                Toast.makeText(EditTestActivity.this,s,Toast.LENGTH_LONG).show();
            }

        });
    }


}
