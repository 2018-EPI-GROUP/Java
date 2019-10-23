package cn.edu.xiyou.demo;

import java.util.Arrays;

//面向对象的数组
public class myArray {
    //用 Object[] 数组原因是，数组里面什么类型的数据都可以装，属性一般加private修饰，面向对象的三大特性之一
    private Object[] elements;

    public myArray() {
        //无参构造默认长度为0的数组
        this.elements = new Object[0];
    }

    //在末尾给数组添加元素
    public Object[] add(Integer target){
        Object[] obj = new Object[elements.length+1];
        for (int i = 0; i < elements.length; i++) {
            obj[i]=elements[i];
        }
        obj[elements.length]=target;
        elements=obj;

        return elements;
    }

    //查看数组元素
    public void show(){
        System.out.println(Arrays.toString(elements));
    }

    /**
     *
     * @param target    所要插入的元素
     * @param index     指定的索引
     * @return
     */
    //在指定索引处插入元素，并扩容数组
    public  Object[] insertArr(Object target, int index) {
        if(index < 0 || index >= elements.length){
            throw new RuntimeException("角标越界...");
        }
        Object[] newArr = new Object[elements.length + 1];
        newArr[index]=target;
        int startIndex=0;
        for (int i = 0; i < elements.length; i++) {
            //判断是不是目标索引
            if (startIndex==index){
                startIndex++;
            }
            newArr[startIndex]=elements[i];
            startIndex++;
        }
        elements=newArr;
        return elements;
    }

    //获得指定索引处的元素
    public Object getElement(Integer index){
        if(index < 0 || index >= elements.length){
            throw new RuntimeException("角标越界...");
        }
        return elements[index];
    }

    //替换指定索引处的元素
    public void replaceElement(Object target,Integer index){
        if(index < 0 || index >= elements.length){
            throw new RuntimeException("角标越界...");
        }
        elements[index]=target;
    }

    //删除指定索引处的元素
    public Object[] deleteArr(int index) {
        if(index < 0 || index >= elements.length){
            throw new RuntimeException("角标越界...");
        }
        Object[] newArr = new Object[elements.length - 1];
        int startIndex=0;
        for (int i = 0; i < newArr.length; i++) {
            //判断是不是目标索引
            if(startIndex==index){
                startIndex++;
            }
            newArr[i]=elements[startIndex];
            startIndex++;
        }
        elements=newArr;
        return elements;
    }

    //获得数组的长度
    public int size(){
        return elements.length;
    }

    //清空数组元素
    public void clear(){
        elements=new Object[0];
    }

}
