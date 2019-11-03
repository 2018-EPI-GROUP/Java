package myjavafile;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;

// 玩家类
class Player {
    private LinkedList<Integer> lib;
    private String name;
    private int ID;

    {
        this.lib = new LinkedList<>();
        this.ID = Objects.hashCode(this);
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getID(){
        return this.ID;
    }

    void putCard(Integer Poker) {
        this.lib.add(Poker);
    }

    void clear() {
        this.lib.clear();
    }

    void sort() {
        Collections.sort(this.lib);
    }

    int size()
    {
        return this.lib.size();
    }

    LinkedList<Integer> getLib() {
        return this.lib;
    }
}