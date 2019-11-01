package Deal_cards;

import java.util.ArrayList;

/*
game类就是一桌游戏
 */
public class Game {
    Players playerOne = new Players("库里",new ArrayList<String>());
    Players playerTwo = new Players("詹姆斯",new ArrayList<String>());
    Players playerThree = new Players("莱昂纳德",new ArrayList<String>());

    public void show(){
        playerOne.show();
        playerTwo.show();
        playerThree.show();
    }

}
