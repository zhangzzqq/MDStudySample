package com.example.administrator.myapplication.enumstudy;

/**
 * Created by steven on 2018/5/26.
 */
public enum CheckFlag {


    CHECK_FLAG("check", 0),
    NONE_CHECK_FLAG("noCheck", 1);

    private String mStatus;
    private int mValue;


    CheckFlag(String status, int value) {
        this.mStatus = status;
        this.mValue = value;
    }

    public String getmStatus() {
        return mStatus;
    }

    public int getmValue() {
        return mValue;
    }

    @Override
    public String toString() {
        return String.valueOf(mValue);
    }

    public static CheckFlag findByValue(int value) {
        for (CheckFlag checkFlag : CheckFlag.values()) {
            if (checkFlag.mValue == value) {
                return checkFlag;
            }
        }
        throw new IllegalArgumentException("No matching constant for [" + value + "]");
    }

    public static CheckFlag findByName(String strStatus) {


        for (CheckFlag checkFlag : CheckFlag.values()) {
            if (checkFlag.mStatus.equals(strStatus)) {
                return checkFlag;
            }
        }
        throw new IllegalArgumentException("No matching constant for [" + strStatus + "]");
    }

    public static CheckFlag setStatus(String status){
        for(CheckFlag checkFlag: values()){
            if(checkFlag.mStatus.equals(status)){
                return checkFlag;
            }
        }
        throw new IllegalArgumentException("No matching constant for [" + status + "]");
    }
}
