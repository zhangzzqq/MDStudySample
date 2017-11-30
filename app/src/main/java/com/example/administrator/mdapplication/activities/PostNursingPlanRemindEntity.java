package com.example.administrator.mdapplication.activities;

/**
 * Created by steven on 2017/11/6 0006.
 */

public class PostNursingPlanRemindEntity {


    /**
     * resultCode : 1000
     * message : 操作成功！
     * data : 1
     */

    private int resultCode;
    private String message;
    private int data;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
