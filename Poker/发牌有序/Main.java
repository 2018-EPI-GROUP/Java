//不知道做成什么样，照自己的理解写的
package myjavafile;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // 创建玩家
        Player one = new Player("玩家1");
        Player two = new Player("玩家2");
        Player three = new Player("玩家3");

        // 创建游戏
        PokerGame newGame = new PokerGame();
        newGame.join(one);
        newGame.join(two);
        newGame.join(three);

        // 在一桌游戏中进行多局游戏
        for (int i = 0; i < 2; i++) {

            newGame.dealPoker();

            newGame.show(one);
            newGame.show(two);
            newGame.show(three);
            newGame.show();
            System.out.println("======================================================================================");

            newGame.recovery();
            Thread.sleep(2000);
        }
        newGame.exit(one);
        newGame.exit(two);
        newGame.exit(three);
    }
}