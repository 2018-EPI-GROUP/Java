package Demo08;
/*
发红包的例子
 */
public class User {
    private String name;
    private int money;


    public void show(){
        System.out.println("我叫" + name + ",我有" + money + "钱");
    }
    public User(){
    }

    public User(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public void setMoney(int money){
        this.money = money;
    }
    public int getMoney(){
        return this.money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
