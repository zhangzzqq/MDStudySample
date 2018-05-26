package com.example.administrator.mdapplication.enumstudy;

import java.text.DecimalFormat;

/**
 * 状态enum，包括端口状态和机房位置状态
 * Created by liuwenjie on 2017/6/19.
 */

public enum Status {
    FREE(0, "空闲"),
    PREOCCUPIED(1, "预占用"),
    OCCUPIED(2, "占用"),
    BROKEN(3, "故障"),
    TEST(4, "测试"),
    NONENDPOINT(5, "不成端"),
    DISABLE(6, "不可用"),
    ERROR(7, "数据错误");
    private static final DecimalFormat formatter = new DecimalFormat("0");
    private final int value;
    private final String name;

    Status(int value, String name) {
        this.value = value;
        this.name = name;
    }

    /**
     * 根据整型值获取资源类别枚举值
     */
    public static Status valueOf(int value) {
        for (Status status : values()) {
            if (status.value == value) {
                return status;
            }
        }
        return ERROR;
//        throw new IllegalArgumentException("No matching constant for [" + formatter.format(value) + "]");
    }

    /**
     * 根据资源类别名称获取资源类别枚举值
     */
    public static Status findByName(String name) {
        for (Status status : values()) {
            if(status.name.equals(name)){
                return status;
            }
        }
        return ERROR;
//        throw new IllegalArgumentException("No matching constant for [" + name + "]");
    }

    /**
     * 根据资源标识获取资源类别枚举值
     */
    public static Status parse(String statusID) {
        if(statusID.equals(""))
            statusID="7";
        return valueOf(Integer.valueOf(statusID));
    }


    /**
     * 获取资源类别的整型值
     */
    public int value() {
        return this.value;
    }

    /**
     * 获取资源类别的名称
     */
    public String getStatusName() {
        return this.name;
    }

    /**
     * 获取资源类别的1位字符串值
     */
    @Override
    public String toString() {
        return formatter.format(value);
    }

//    @Override
//    public String toString() {
//        return formatter.format(value)+name;
//    }


//    public static void main (String [] args){
//
//        for(Status status :Status.values()){
//
//            System.out.print(status);
//        }
//
//    }
}
