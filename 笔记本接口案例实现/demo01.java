package Demo02;

public class demo01 {

    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.powerOn();

        //使用多台写法，向上转型
        USB usb = new Mouse();
        computer.useDevice(usb);
        System.out.println("===========");

        KeyBoard keyBoard = new KeyBoard();
        computer.useDevice(keyBoard);//发生了向上转型
        /*
        这里的keyBoard虽然是USB的实现类，但是也可以作为参数

        举例：
        int num = 10;
        method(10);
        public void method(double num){
            System.out.println(num);
        }
        打印结果10.0
         */

        computer.powerOff();
    }
}
