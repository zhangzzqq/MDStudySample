package com.example.javamodule.array;

/**
 * Created by steven on 2018/5/27.
 */

/**
 * 找出最小的数
 * <p>
 * <p>
 * 一个临时变量记住最小的数就好了
 */
public class ArrayStudy {


    public static int points[] = {0, 9, 7, 4, 3, 11, 0, 0, 2, 11, -4, -1};

    int score[] = new int[3];
    int hobby[] = new int[]{};


    private static int temp;

    public static void main(String[] args) {
//        private static  int temp=points[0];
//        for(int i=0;i<points.length;i++){
//
//            if(temp>points[i]){
//
//                temp =points[i];
//            }
//
//        }
//
//        System.out.println("最小值是=="+temp);

/**
 *  排序
 *
 *  两个for循环进行比较
 *
 *  把小的放在前面大的放在后面
 *
 *  用临时temp交换值
 * 12,-1,23,0,8,0,-2 这几个数从12到-2，需要拿出来进行比较的有6（6次 points.length-1）
 *
 * 两两进行比较的话，最后一个不数需要比较 6（6次 points.length-1）
 *
 *
 * 36次
 */

//                for(int i=0;i<points.length-1;i++){
//                  for(int j=0;j<points.length-1;j++){
//                      if(points[j]>points[j+1]){
//                          temp =points[j+1];
//                          points[j+1]=points[j];
//                          points[j]=temp;
//
//                      }
//                  }
//                }

        /**
         *
         * 思路跟上面的一样
         * i和j直接进行比较 （j配合i），就是相邻的进行比较，直到所有的比较晚
         *
         * 第一次循环points.length-1原因是倒数第一个数不需要再进行比较了，
         * 因为倒数第二个数在进行比较的是偶默认就是与到时第一个数进行比较
         *
         * 相邻的进行比较，每一轮排序的结果是把最大的数放在前面，像在冒泡一样。
         * 冒泡排序
         * 7 6 5 4 3 2 1 =23次
         *
         */
//        for(int i=0;i<points.length-1;i++){
//
//            for(int j=i+1;j<points.length;j++){
//
//                if(points[i]>points[j]){
//
//                    temp=points[i];
//                    points[i]=points[j];
//                    points[j]=temp;
//
//                }
//            }
//        }


        quickSort(points);


        for (int i = 0; i < points.length; i++) {

            System.out.println("排序后的结果==" + points[i]);
        }
    }

    /**
     * 快速排序
     *
     * @param arr http://blog.51cto.com/flyingcat2013/1281614
     *            <p>
     *            <p>
     *            从宏观上看容易懂，在微观上看不容易懂
     */
    public static void quickSort(int[] arr) {

        qsort(arr, 0, arr.length - 1);

    }

    private static void qsort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);        //将数组分为两部分
            qsort(arr, low, pivot - 1);                   //递归排序左子数组
            qsort(arr, pivot + 1, high);                  //递归排序右子数组
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int temp = arr[low];     //枢轴记录
        while (low < high) {
            while (low < high && arr[high] >= temp) --high;
            arr[low] = arr[high];             //交换比枢轴小的记录到左端
            while (low < high && arr[low] <= temp) ++low;
            arr[high] = arr[low];           //交换比枢轴小的记录到右端
        }
        //扫描完成，枢轴到位
        arr[low] = temp;
        //返回的是枢轴的位置
        return low;
    }


    /**
     * 插入排序
     */


    public static void sort(int[] numbers) {

        for (int i = 1; i < numbers.length; i++) {

            int currentNumber = numbers[i];

            int j = i - 1;
            while (j >= 0 && numbers[j] > currentNumber) {
                numbers[j + 1] = numbers[j];
                j--;
            }

            numbers[j + 1] = currentNumber;

        }
    }



}
