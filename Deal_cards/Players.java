package Deal_cards;
/*
各位玩家
 */
import java.util.ArrayList;

public class Players {
    private String name;
    //private ArrayList<String> card;报控制针异常，因为没有在堆内存中开辟这个空间。
    private ArrayList<String> card = new ArrayList<String>();

    public Players() {
    }

    public Players(String name, ArrayList<String> card) {
        this.name = name;
        this.card = card;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getCard() {
        return card;
    }

    public void setCard(ArrayList<String> card) {
        this.card = card;
    }

    public void show(){
        System.out.println(getName() +"的牌是" + getCard());
    }

    public void add(String str){
        this.card.add(str);
    }
}
