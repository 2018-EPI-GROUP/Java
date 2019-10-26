package leetcodeDemo01;

public class SolutionDemo01 {
    public int lengthOfLongestSubstring(String s) {
        int  size,i=0,j,k,max=0;
          char[] chars = s.toCharArray();
           for(j = 0;j<chars.length;j++){
               for(k = i;k<j;k++)
                   if(chars[k]==chars[j]){
                       i = k+1;
                       break;
                   }
               if(j-i+1 > max)
                   max = j-i+1;
           }
           return max; 
       }
}
