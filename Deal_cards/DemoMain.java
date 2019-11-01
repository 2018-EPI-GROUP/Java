package Deal_cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/*
斗地主发牌小游戏
 */
public class DemoMain {

    public static void main(String[] args) {
        //创建三个玩家一起玩这个游戏
        Game game1 = new Game();

        //往牌库放一副牌，library牌库
        ArrayList<String> library = method1();

        //发牌

        for (int i = 0; i < library.size()-3; i++) {
            switch(i % 3){
                case 0:game1.playerOne.add(library.get(i));break;
                case 1:game1.playerTwo.add(library.get(i));break;
                case 2:game1.playerThree.add(library.get(i));break;
            }
//            library.remove(i);加了就错了
        }

        //抢地主(抽签决定),给地主的那个人剩下的三张牌
        method3(game1,library);

        //显示三个人牌
        game1.show();

        System.out.println("游戏开始");
    }




    //给地主三张底牌
    public static void method(ArrayList<String> strArr, ArrayList<String> library){
        for (int i = library.size()-3 ; i < library.size(); i++) {
            strArr.add(library.get(i));
        }
    }
    //洗牌
    public static ArrayList<String> method1(){
        String[] str1 = {"♥","♠","♦","♣"};
        String[] str2 = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};

        ArrayList<String> library = new ArrayList<String>();
        for (int i = 0; i < str1.length; i++) {
            for (int i1 = 0; i1 < str2.length; i1++) {
                library.add(str1[i]+str2[i1]);
            }
        }
        library.add("小王");
        library.add("大王");

        //洗牌
        Collections.shuffle(library);
        return library;
    }
    //抢地主并把三张底牌给到地主的牌库
    public static void method3(Game game, ArrayList<String> library){
        int ran = new Random().nextInt(3);
        if(0 == ran){
            method(game.playerOne.getCard(),library);
            System.out.println("地主是：" + game.playerOne.getName());
        }
        else if(1 == ran){
            System.out.println("地主是：" + game.playerTwo.getName());
            method(game.playerTwo.getCard(),library);
        }
        else{
            method(game.playerThree.getCard(),library);
            System.out.println("地主是：" + game.playerThree.getName());
        }
    }
}
