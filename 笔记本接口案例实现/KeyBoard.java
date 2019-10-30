package Demo02;

public class KeyBoard implements USB{
    @java.lang.Override
    public void powerDevice() {
        System.out.println("打开键盘");
    }
    @java.lang.Override
    public void offDevice() {
        System.out.println("关闭键盘");
    }

    public void type(){
        System.out.println("键盘打印");
    }
}
