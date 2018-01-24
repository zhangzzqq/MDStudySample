package com.example.administrator.mdapplication.utils;

/**
 * Created by Harrison.Pan on 2017/06/20.
 */

public class NumberUtils {

    public static String toString(Double value, int precision) {

        if (value == null) {
            return "0";
        }

        if (value.doubleValue() == value.intValue()) {
            return String.valueOf(value.intValue());
        } else {
            return String.format("%." + precision + "f", value);
        }
    }

}
