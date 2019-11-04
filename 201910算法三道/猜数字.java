package EPI任务;

public class 猜数字 {
    public static void main(String[] args) {
        int[] a={1,1,3};
        int[] b={2,2,3};
        System.out.println(new Soluti().game(a,b));
    }
}
class Soluti {
    public int game(int[] guess, int[] answer) {
        int i=0;
        int j=0;
        for(i=0;i<3;i++){
            while(guess[i]==answer[i]){
                j++;
                break;
            }
        }
        return j;
    }
}
