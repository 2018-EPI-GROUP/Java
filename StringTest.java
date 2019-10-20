package cn.edu.xiyou.ListNodeTest;

public class StringTest {
    public static void main(String[] args) {
        String s = new String("abcabcbb");
        int i = lengthOfLongestSubstring(s);

        System.out.println(i);
    }
    private static int lengthOfLongestSubstring(String s) {
        int len=0;
        String s1;
        for (int i = 0; i < s.length(); i++) {
            len=1>len?1:len;
            for (int j = i+1; j < s.length(); j++) {
                 s1= s.substring(i,j);
                 if(s1.contains(s.substring(j,j+1))){
                     len=s1.length()>len?s1.length():len;
                     break;
                 }else {
                     len=s1.length()+1>len?s1.length()+1:len;
                 }
            }
            if(len==s.length()-i)
                break;
        }
        return len;
    }
}
