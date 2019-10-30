package Demo02;

public class Computer {
    public void powerOn(){
        System.out.println("打开电脑");
    }
    public void powerOff(){
        System.out.println("关闭电脑");
    }
    public void useDevice(USB usb){
        usb.powerDevice();
        if(usb instanceof Mouse) {
            Mouse mouse = (Mouse) usb;
            mouse.click();
        }
        if(usb instanceof KeyBoard){
            KeyBoard keyboard = (KeyBoard) usb;
            keyboard.type();
        }
        usb.offDevice();
    }
}
