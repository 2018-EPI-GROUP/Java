public class Solution {
    public static void main(String[] args) {
        String str="asdfsgdgdcxeaasdae";
        System.out.println(longestPalindrome(str));
    }
    public static String longestPalindrome(String s) {
        String result="";
        for (int i = s.length(); i > 0; i--) {
            if(i==1){
                result=s.substring(0,1);
                break;
            }
            for (int j = 0; j <= s.length()-i; j++) {
                for (int k = 0; k < i/2; k++) {
                    Boolean flag = s.substring(j+k, j+k+1).equals(s.substring((i-1)+j-k, i+j-k));
                    if(!flag){
                        break;
                    }
                    if(k==(i-2)/2){
                        result=s.substring(j,j+i);
                    }
                }
            }
            if(!(result.equals(""))){
                break;
            }
        }
        return result;
    }
}