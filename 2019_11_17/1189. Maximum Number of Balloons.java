/*
	统计字符串中字母'b' 'a' 'l' 'o' 'n'的数量
	'l'和'o'的数量要除以2
	最小值就是能拼凑出单词"balloon"的个数
*/
class Solution {

    public int maxNumberOfBalloons(String text) {
        int[] balon = new int[5];
        for (int i = 0; i < text.length(); i++) {
            switch (text.charAt(i)) {
                case 'b':
                    balon[0]++;
                    break;
                case 'a':
                    balon[1]++;
                    break;
                case 'l':
                    balon[2] += 1; // 数组是整形 不能每次加0.5 要每次加1再除以2
                    break;
                case 'o':
                    balon[3] += 1;
                    break;
                case 'n':
                    balon[4]++;
                    break;
                default:
                    break;
            }
        }
        balon[2] /= 2;
        balon[3] /= 2;    

        int maxNumber = balon[0];
        for (int i = 1; i < balon.length; i++) {
            maxNumber = Math.min(maxNumber, balon[i]);
        }

        return maxNumber;
    }

}