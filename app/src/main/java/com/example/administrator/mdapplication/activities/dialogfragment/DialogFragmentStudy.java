package com.example.administrator.mdapplication.activities.dialogfragment;

/**
 * Created by steven on 2018/1/18.
 */

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatDialogFragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import org.apache.commons.lang3.StringUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Title:DialogFragment基类
 * Description:
 * <p>
 * Created by pei
 * Date: 2017/12/4
 */
public abstract class DialogFragmentStudy extends AppCompatDialogFragment implements View.OnClickListener{

    private static final int RID=-1;//默认背景资源id
    public static final int WRAP_CONTENT=-2;//dialog窗口大小自适应
    public static final int MATCH_PARENT=-3;//dialog窗口全屏

    protected View mLayoutView;
    private Unbinder mUnbinder;
    private Context mContext;
    private boolean mBackCancel=true;//默认点击返回键关闭dialog
    private boolean mTouchOutsideCancel=true;//默认点击dialog外面屏幕，dialog关闭
    private int mBackGroundId=RID;//背景资源id，类似R.drawable.ui_shape_gray_round_corner
    protected double mScaleWidth=WRAP_CONTENT;//屏幕宽度比例
    protected double mScaleHeight=WRAP_CONTENT;//屏幕高度比例
    private static final String TAG ="DialogFragmentStudy";


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context;
        Log.e(TAG,"======我被调用了======");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        double windowSize[]=getWindowSize();
        if(windowSize!=null){
            mScaleWidth=windowSize[0];
            mScaleHeight=windowSize[1];
        }
        //设置全屏
        if(mScaleWidth==MATCH_PARENT&&mScaleHeight==MATCH_PARENT){
            setStyle(STYLE_NO_FRAME, android.R.style.Theme_Holo_Light);
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mLayoutView = inflater.inflate(getLayoutId(), container, false);
        mUnbinder= ButterKnife.bind(this,mLayoutView);//绑定framgent
        //初始化
        onCreateFragmentView(inflater, container, savedInstanceState);
        return mLayoutView;
    }

    protected void onCreateFragmentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initData();
        setListener();
    }

    @Override
    public void onStart() {
        super.onStart();
        //设置窗口属性
        setDialog();
    }

    /**设置窗口属性**/
    private void setDialog(){
        Dialog dialog=getDialog();
        if(dialog!=null) {
            //返回键是否消失
//        getDialog().setCancelable(mBackCancel);
            dialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
                @Override
                public boolean onKey(DialogInterface dialogInterface, int keyCode, KeyEvent keyEvent) {
                    if (keyCode == KeyEvent.KEYCODE_BACK) {
                        return !mBackCancel;
                    }
                    return false;
                }
            });
            //触碰dialog外面是否消失
            dialog.setCanceledOnTouchOutside(mTouchOutsideCancel);
            //设置窗口大小
            setWindowSize(dialog);
        }
    }

    /**设置窗口大小**/
    private void setWindowSize(Dialog dialog){
        Window window = dialog.getWindow();
        if(window!=null) {
            //设置背景
            if (mBackGroundId != RID) {
                window.setBackgroundDrawableResource(mBackGroundId);
            }
            //设置透明度
            WindowManager.LayoutParams windowParams = window.getAttributes();
            windowParams.dimAmount = 0.0f;
            windowParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
            windowParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
            window.setAttributes(windowParams);

            if(mScaleWidth!=MATCH_PARENT&&mScaleHeight!=MATCH_PARENT){
                DisplayMetrics dm = new DisplayMetrics();
                ((FragmentActivity) mContext).getWindowManager().getDefaultDisplay().getMetrics(dm);
                setWindowWidth(windowParams,dm);//设置宽度
                setWindowHeight(windowParams,dm);//设置高度
                window.setLayout(windowParams.width,windowParams.height);
            }

        }
    }

    /**设置窗口宽度**/
    private void setWindowWidth(WindowManager.LayoutParams windowParams,DisplayMetrics dm) {
        if (mScaleWidth == WRAP_CONTENT) {
            windowParams.width = ViewGroup.LayoutParams.WRAP_CONTENT;
        } else if (mScaleWidth > 0) {
            windowParams.width = (int) (dm.widthPixels * mScaleWidth); // 宽度设置为屏幕的0.65
        } else {
            throw new UnknownError("dialog宽度系数设置错误");
        }
    }

    /**设置窗口高度**/
    private void setWindowHeight(WindowManager.LayoutParams windowParams,DisplayMetrics dm) {
        if (mScaleHeight == WRAP_CONTENT) {
            windowParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        } else if (mScaleHeight > 0) {
            windowParams.height = (int) (dm.heightPixels * mScaleHeight); // 高度设置为屏幕的0.6
        } else {
            throw new UnknownError("dialog高度系数设置错误");
        }
    }

    @Override
    public void onClick(View v) {
//        DoubleClickUtil.shakeClick(v);
    }

    @Override
    public void onDestroy() {
        if(mUnbinder!=null){
            mUnbinder.unbind();
        }
        super.onDestroy();
    }

    protected abstract double[] getWindowSize();
    protected abstract int getLayoutId();
    protected abstract void initData();
    protected abstract void setListener();


    /**设置dialog背景色**/
    public DialogFragmentStudy setBackGroundId(int rId){
        this.mBackGroundId=rId;
        return this;
    }

    /**设置点击返回键是否关闭dialog**/
    public DialogFragmentStudy setCancel(boolean canDismiss) {
        this.mBackCancel = canDismiss;
        return this;
    }

    /**设置点击屏幕外面是否关闭dialog**/
    public DialogFragmentStudy setCancelOnTouchOutside(boolean canDismiss){
        this.mTouchOutsideCancel=canDismiss;
        return this;
    }

    /***
     * 显示dialog，需要传 fragmentManager=getSupportFragmentManager()
     * @param fragmentManager
     */
    public void showDialog(FragmentManager fragmentManager){
        try {
            String className=this.getClass().getSimpleName();
            this.show(fragmentManager,className);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG,"===showDialog error===="+e.getMessage());
        }
    }

    /**获取editText的值**/
    protected String getTextOfEditText(EditText et){
        if (et == null) {
            return null;
        }
        if (et.getText() == null) {
            return null;
        }
        if (StringUtils.isEmpty(et.getText().toString())) {
            return "";
        }
        return et.getText().toString().trim();
    }


}


//==============================自定义dialogFragment的使用范例==================================
//public class MyFragmentDialog extends AppDialogFragment{
//
//    @BindView(R.id.btn_test)
//    Button mBtnTest;
//
//    @Override
//    protected double[] getWindowSize() {
//        return new double[]{0.5,0.5};
//    }
//
//    @Override
//    protected int getLayoutId() {
//        return R.layout.dialog_fragment_test;
//    }
//
//    @Override
//    protected void initData() {
//
//    }
//
//    @Override
//    protected void setListener() {
//
//    }
//}
