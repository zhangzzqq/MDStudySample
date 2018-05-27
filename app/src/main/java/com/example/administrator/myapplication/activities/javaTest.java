package com.zq.administrator.mdapplication.activities;

import com.zq.administrator.mdapplication.utils.NumberUtils;

/**
 * Created by steven on 2017/11/13 0013.
 */

public class javaTest {

    private static String result;
    private static String strNewResult;


    public static void main(String agrs[]) {
        result = "5/8/9";
        strNewResult = result.substring(1, result.length());
        System.out.println("strNewResult==" + strNewResult);

        String strResult = NumberUtils.toString(1.260, 10);
        System.out.println(strResult);


    }


}
