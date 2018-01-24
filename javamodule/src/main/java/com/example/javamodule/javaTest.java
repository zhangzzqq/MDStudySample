package com.example.javamodule;


/**
 * Created by steven on 2017/11/13 0013.
 * <p>
 * 枚举toString或者getValue()都是可以获得值的
 *
 * 枚举中的方法可以是int或者String类型
 */

public class javaTest {


    public static void main(String[] args) {

//        String strResult = String.valueOf(QueryType.BACKWARD.getValue());
//        System.out.println("strResult=="+strResult);

        // 比较此枚举与指定对象的顺序。
//        System.out.println(WeekEnum.FRIDAY.compareTo(WeekEnum.MONDAY));
//        System.out.println(WeekEnum.FRIDAY.compareTo(WeekEnum.SUNDAY));
//        System.out.println(WeekEnum.FRIDAY.compareTo(WeekEnum.SATURDAY));

// 没有重写 toString 方法
//        for (WeekEnum we : WeekEnum.values()) {
//            System.out.println(we);
//        }

//        System.out.println(WeekEnum.FRIDAY.getDate());
//        System.out.println(WeekEnum.FRIDAY.toString());

        //=======================================
        String strResult = QueryType.BACKWARD.toString();
        int value = QueryType.BACKWARD.getValue();
        System.out.println("strResult==" + strResult);
        System.out.println(value);

    }


}
