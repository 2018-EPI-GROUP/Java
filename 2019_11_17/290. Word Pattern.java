class Solution {

    public boolean wordPattern(String pattern, String str) {
        String[] strArray = str.split(" ");
        if (pattern.length() != strArray.length) { // 如果pattern里字母的个数和字符串str中非空单词的个数不相等 肯定不会完全匹配
            return false;
        }

        Map<String, String> map = new HashMap<String, String>(); // pattern里的字母为键 str中非空的单词为值 字母和单词一对一
        boolean flag = true;
        for (int i = 0; i < strArray.length; i++) {
            String patternSubString = pattern.substring(i, i + 1);
            if (!map.containsKey(patternSubString)) {
                if (map.containsValue(strArray[i])) { // 多对一的情况 不完全匹配
                    flag = false;
                    break;
                }
                map.put(patternSubString, strArray[i]); // 一对一的情况 将字母和单词放入哈希表中
            } else {
                if (!map.get(patternSubString).equals(strArray[i])) { // 一对多的情况 不完全匹配
                    flag = false;
                    break;
                }
            }
        }

        return flag;
    }

}