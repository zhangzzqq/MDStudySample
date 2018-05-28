import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.EditText;

import com.zq.administrator.mdapplication.R;
import com.zq.administrator.mdapplication.utils.ToastUtils;
import com.zq.administrator.myapplication.BaseActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yifeng on 16/11/25.
 *
 */

public class TextInputActivity extends BaseActivity {

    private TextInputLayout mMobileTil;

    public static void startActivity(Context context ){
        Intent intent = new Intent(context, TextInputActivity.class);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_input);

        mMobileTil = (TextInputLayout) findViewById(R.id.til_mobile);

    }

    public void onClickLogin(View v){
        if (verifyMobile()){
            mMobileTil.setErrorEnabled(false);
            ToastUtils.showToast(this, "Success");
        }else{
            mMobileTil.setErrorEnabled(true);
            mMobileTil.setError("手机号格式错误");
        }

    }

    public boolean verifyMobile(){
        Pattern pattern = Pattern.compile("1\\d{10}");
        Matcher matcher = pattern.matcher(((EditText) findViewById(R.id.et_mobile)).getText().toString());
        return  matcher.matches();
    }

}
