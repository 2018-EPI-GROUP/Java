package course;
/*
12:求1+2!+3!+...+20!的和
 */
public class Title12 {
    public static void main(String[] args) {
        sum();
    }
    public static void sum(){
        int sum=1;
        int j=1;
        System.out.printf("1!");
        for(int i=2;i<=20;i++){
            j*=i;
            sum+=j;
            System.out.printf("+"+i+"!");
        }
        System.out.println("="+sum);
    }
}
