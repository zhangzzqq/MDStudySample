package com.example.administrator.mdapplication.enumerate;

/**
 * Created by Harrison.Pan on 2017/09/05.
 */

public enum QueryType {

    BACKWARD(0),//之前的 过去的
    FORWARD(1),//后面的 下面的
    NORMAL(2);

    private int value;

    QueryType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

//    @Override
//    public String toString() {
//        switch (value) {
//            case 0:
//                return "0";
//            case 1:
//                return "1";
//            case 2:
//                return "2";
//        }
//        return "0";
//    }
}
