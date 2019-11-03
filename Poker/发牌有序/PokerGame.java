package myjavafile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

// 扑克游戏
class PokerGame {
    private static HashMap<Integer, String> pokerMap;

    private ArrayList<Integer> allPoker = new ArrayList<>(); // 本桌所有的扑克
    private ArrayList<Integer> ace = new ArrayList<>(); // 底牌
    private ArrayList<Player> playerList = new ArrayList<>();

    // 组装扑克
    static {
        pokerMap = new HashMap<>();
        String[] color = { "♥", "♠", "♣", "♦" };
        String[] number = { "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2" };
        int i = 0;
        for (String n : number) {
            for (String c : color) {
                pokerMap.put(++i, c + n);
            }
        }
        pokerMap.put(53, "小王");
        pokerMap.put(54, "大王");
    }

    {
        for (int i = 1; i <= 54; i++) {
            this.allPoker.add(i);
        }
    }

    // 构造函数
    public PokerGame() {
    }

    // 玩家加入
    public void join(Player player) {
        if (player == null) {
            throw new RuntimeException("玩家信息错误!");
        }
        if (this.playerList.size() >= 3) {
            throw new RuntimeException("玩家数量已满!");
        }
        if (this.playerList.contains(player)) {
            throw new RuntimeException("玩家已存在!");
        }
        if (this.playerList.add(player)) {
            System.out.println(player.getName() + "加入房间");
        } else {
            System.out.println("加入房间失败!");
        }
    }

    // 玩家退出
    public void exit(Player player) {
        if (player == null) {
            throw new RuntimeException("玩家信息错误!");
        }
        if (this.playerList.remove(player)) {
            System.out.println(player.getName() + "退出房间");
        } else {
            throw new RuntimeException("玩家不存在!");
        }
    }

    // 获取游戏内玩家的数量
    public int num()
    {
        return this.playerList.size();
    }

    // 洗牌 发牌 开始新一局
    public void dealPoker() {
        if(this.num()!=3){
            throw new RuntimeException("人数不足!");
        }

        // 洗牌
        Collections.shuffle(allPoker);

        // 发牌
        Iterator<Integer> it = this.allPoker.iterator();// 发牌姬
        for (int i = 0; i < 51; i++) {
            switch (i % 3) {
            case 0:
                this.playerList.get(0).putCard(it.next());
                break;
            case 1:
                this.playerList.get(1).putCard(it.next());
                break;
            case 2:
                this.playerList.get(2).putCard(it.next());
                break;
            }
        }
        while (it.hasNext()) {
            this.ace.add(it.next());
        }

        // 整理牌
        this.playerList.get(0).sort();
        this.playerList.get(1).sort();
        this.playerList.get(2).sort();
        Collections.sort(this.ace);
    }

    // 输出给定集合中索引对应的牌
    private String print(List<Integer> l) {
        StringBuilder resute = new StringBuilder("[");
        int size = l.size();
        if (size == 0) {
            resute.append(" ]");
        } else {
            int key = l.get(0);

            for (int i = 1; i <= size - 1; i++) {
                if (key < 1 || key > 54) {
                    throw new RuntimeException("索引不存在!");
                }

                resute.append(pokerMap.get(key) + ", ");
                key = l.get(i);
            }

            if (key < 1 || key > 54) {
                throw new RuntimeException("索引不存在!");
            }

            resute.append(pokerMap.get(l.get(size - 1)) + "]");
        }

        return resute.toString();
    }

    // 展示底牌
    public void show() {
        System.out.println("底牌有" + this.ace.size() + "张: " + this.print(this.ace));
    }

    public void show(Player player){
        System.out.println(player.getName() + "有" + player.size() + "张牌: " + this.print(player.getLib()));
    }

    // 回收所有玩家和底牌的牌
    public void recovery() {
        this.playerList.get(0).clear();
        this.playerList.get(1).clear();
        this.playerList.get(2).clear();
        this.ace.clear();
    }
}
