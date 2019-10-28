package Demo08;

import java.util.ArrayList;

public class demo {

    public static void main(String[] args) {
        Manger manger = new Manger("群主",100);
        Receive one = new Receive("成员A",0);
        Receive two = new Receive("成员B",0);
        Receive three = new Receive("成员c",0);

        manger.show();
        one.show();
        two.show();
        three.show();
        System.out.println("==============================");
        ArrayList<Integer> list = manger.send(20,3);
        one.addMoney(list);
        two.addMoney(list);
        three.addMoney(list);

        manger.show();
        one.show();
        two.show();
        three.show();

    }
}
