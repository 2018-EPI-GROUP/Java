package Demo08;

import java.util.ArrayList;
import java.util.Random;

public class Receive extends User{
    //俩个构造方法
    public Receive(){
    }
    public Receive(String name, int money){
        super(name, money);
    }

    //收红包的成员方法
    public void addMoney(ArrayList<Integer> list){
        //从集合中取出一个随机下标的金额
        int index = new Random().nextInt(list.size());
        int money = super.getMoney() + list.get(index);
        //把取出来的金额加到对应的对象的money上
        super.setMoney(money);
        //把原来那个集合里的金额删掉（remove）
        list.remove(index);
    }
}
