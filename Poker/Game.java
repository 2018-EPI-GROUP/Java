package Poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Game {
    public static void main(String[] args) {
        // 创建游戏
        PokerGame newGame = new PokerGame("玩家1", "玩家2", "玩家3");

        //在一桌游戏中进行多局游戏
        for (int i = 0; i < 3; i++) {
            // 开始
            newGame.again();

            // 看牌
            newGame.read();
        }
    }
}

class PokerGame {
    private ArrayList<String> allPoker; // 所有的扑克
    private ArrayList<String> ace; // 底牌
    private Player player01;
    private Player player02;
    private Player player03;

    {
        this.allPoker = new ArrayList<>();
        this.ace = new ArrayList<>();
        this.product();
    }

    public PokerGame(String player01Name, String player02Name, String player03Name) {
        this.player01 = new Player(player01Name);
        this.player02 = new Player(player02Name);
        this.player03 = new Player(player03Name);
    }

    private class Player {
        private LinkedList<String> Poker;
        private String name;

        {
            this.Poker = new LinkedList<>();
        }

        Player(String name) {
            this.name = name;
        }

        String getName() {
            return this.name;
        }

        void add(String Poker) {
            this.Poker.add(Poker);
        }

        void clear() {
            this.Poker.clear();
        }

        int length() {
            return this.Poker.size();
        }

        String getPoker() {
            return this.Poker.toString();
        }

        public String toString() {
            return this.getName() + " 牌数 " + this.length() + ": " + this.getPoker();
        }
    }

    // 新一局
    public void again() {
        this.recovery();
        this.shufflePoker();
        this.dealPoker();
    }

    // 组装扑克
    private void product() {
        String[] color = { "♥", "♠", "♣", "♦" };
        String[] number = { "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2" };
        for (String c : color) {
            for (String n : number) {
                this.allPoker.add(c + n);
            }
        }
        this.allPoker.add("小王");
        this.allPoker.add("大王");
    }

    // 洗牌
    private void shufflePoker() {
        Collections.shuffle(allPoker);
    }

    // 发牌
    private void dealPoker() {
        Iterator<String> allPokerIter = this.allPoker.iterator();
        for (int i = 0; i < 51; i++) {
            if (i % 3 == 0) {
                this.player01.add(allPokerIter.next());
            } else if (i % 3 == 1) {
                this.player02.add(allPokerIter.next());
            } else {
                this.player03.add(allPokerIter.next());
            }
        }
        while (allPokerIter.hasNext()) {
            this.ace.add(allPokerIter.next());
        }
    }

    // 结束看牌
    public void read() {
        System.out.println(this.player01);
        System.out.println(this.player02);
        System.out.println(this.player03);
        System.out.println("底牌：" + this.ace);
    }

    // 回收所有玩家和底牌的牌
    private void recovery() {
        this.player01.clear();
        this.player02.clear();
        this.player03.clear();
        this.ace.clear();
    }
}