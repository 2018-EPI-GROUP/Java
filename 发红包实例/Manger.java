package Demo08;

import java.util.ArrayList;

/*
群主发红包
 */
public class Manger extends User{
    //俩个构造方法
    public Manger(){
    }
    //调用父类的构造方法
    public Manger(String name, int money) {
        super(name, money);
    }
    //发红包，返回的ArrayList里面存的是每个红包的钱
    public ArrayList<Integer> send(int total, int count){
        //先检查要发得到红包总金额是否已经超过了余额
        if(total > getMoney()){
            System.out.println("余额不足");
            return null;
        }

        ArrayList<Integer> list = new ArrayList<>(count);
        //可能碰到除不尽的情况，那么最后一个红包就是多出来的余数加上平均数
        int ave = total / count;
        int left = total % count;

        for (int i = 0; i < count -1; i++) {
            list.add(ave);
        }
        list.add(left + ave);

        return list;
    }

}
