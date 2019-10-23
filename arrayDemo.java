package cn.edu.xiyou.demo;

import java.util.Arrays;

public class arrayDemo {
    public static void main(String[] args) {
        int[] arr={2,6,7,5,10};
        //即将插入arr数组额目标元素
        int target=3;
        System.out.print("初始数组是：");
        System.out.println(Arrays.toString(arr));
        //调用插入元素并扩容数组的方法，并返回一个新的数组
        arr = insertArr(arr, target, 4);
        System.out.print("插入元素后的数组是：");
        System.out.println(Arrays.toString(arr));
        arr=deleteArr(arr,0);
        System.out.print("删除元素后的数组是：");
        System.out.println(Arrays.toString(arr));
    }

    //在指定索引处插入元素，并扩容数组
    private static int[] insertArr(int[] arr, int target, int index) {
        int[] newArr = new int[arr.length + 1];
        newArr[index]=target;
        int startIndex=0;
        for (int i = 0; i < arr.length; i++) {
            //判断是不是目标索引
            if (startIndex==index){
                startIndex++;
            }
            newArr[startIndex]=arr[i];
            startIndex++;
        }
        return newArr;
    }

    //删除数组指定索引处的元素，并返回一个新数组，此时的数组长度比之前小1
    private static int[] deleteArr(int[] arr, int index) {
        int[] newArr = new int[arr.length - 1];
        int startIndex=0;
        for (int i = 0; i < newArr.length; i++) {
            //判断是不是目标索引
            if(startIndex==index){
                startIndex++;
            }
            newArr[i]=arr[startIndex];
            startIndex++;
        }
        return newArr;
    }

}
