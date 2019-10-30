package Demo02;

public class Mouse implements USB{

    @java.lang.Override
    public void powerDevice() {
        System.out.println("打开鼠标");
    }

    @java.lang.Override
    public void offDevice() {
        System.out.println("关闭鼠标");
    }

    public void click(){
        System.out.println("鼠标点击");
    }
}
