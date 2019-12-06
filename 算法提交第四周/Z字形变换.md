## Z字形变换

- **问题描述**

  ```java
  将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
  
  比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
  
  L   C   I   R
  E T O E S I I G
  E   D   H   N
  之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
  
  请你实现这个将字符串进行指定行数变换的函数：
  
  string convert(string s, int numRows);
  示例 :
  
  输入: s = "LEETCODEISHIRING", numRows = 3
  输出: "LCIRETOESIIGEDHN"
  ```

- **代码实现**

```java
public String convert(String s, int numRows) {
          int i=0,w=0,j=0,p=0;
	    char ch[]=s.toCharArray();
	    int rent = numRows*2-2;
	    StringBuilder sb = new StringBuilder();
	    if(rent==0)
	    	return s;
	    while(j<numRows) {
	    	p=j;
	    	i=w;
	    	while(i<ch.length) {
		    	if(i%rent==p||i%rent==rent-p)
		    		sb.append(ch[i]);
		    	i++;
		    }
	    	j++;
		    w++;
	    }
	    String result = sb.toString();
	    return result;
    }
```

