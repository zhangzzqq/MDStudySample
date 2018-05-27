package com.zq.administrator.mdapplication.enumstudy;

/**
 * Created by Harrison.Pan on 2017/09/05.
 */

public enum QueryType {

    BACKWARD(0),//之前的 过去的
    FORWARD(1),//后面的 下面的
    NORMAL(2);

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    QueryType(int value) {

        this.value = value;
    }

    @Override
    public String toString() {
//        return super.toString();
        return String.valueOf(value);
    }

    public static void main(String [] args){

        for(QueryType queryType: QueryType.values()){

            System.out.println(queryType);
        }

        String strQUeryType =QueryType.BACKWARD.toString();

        QueryType type = QueryType.BACKWARD;

        int a =type.getValue();

        System.out.println("strQUeryType=="+strQUeryType);
        System.out.println("QUeryType=="+type);
        System.out.println("a=="+a);


    }


}
