package EPI任务.算法20191106;

/**
 * 将一个字符串中所有的空格替换为%20
 * 需要注意的：String和StringBuilder
 * StringBuilder要变成String类型需要toString()方法
 * String类的valueOf方法：把别的类型转换为字符串形式
 * * MiseryG
 */

public class _20191106 {
    public static void main(String[] args) {
        String string="Discipline is just choosing between what you want now and what you want most";
        String s1 = replace(string);
        String s2 = replace2(string);
        System.out.println(s1);
        System.out.println(s2);
    }
    //方法1
    public static String replace(String string){
        int len=string.length();
        StringBuilder result = new StringBuilder();
        for(int i=0;i<len;i++){
            char ch=string.charAt(i);
            if(String.valueOf(ch).equals(" ")){//这里必须用equals，不能用==
                result.append("%20");
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
    //方法2
    public static String replace2(String str){
        String s=str.replaceAll("\\s", "%20");//这里可以用" "或者"\\s"
        return s;
    }
}
