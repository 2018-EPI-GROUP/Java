### x的平方根

实现 int sqrt(int x) 函数。

计算并返回 x 的平方根，其中 x 是非负整数。

由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

示例 1:

输入: 4
输出: 2
示例 2:

输入: 8
输出: 2
说明: 8 的平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。

#### 解决方法

##### 方法一:二叉查找

当 x>2 时，它的整数平方根一定小于 x /2 且大于 0，即 0 < a < x / 2。由于 a 一定是整数，此问题可以转换成在有序整数集中寻找一个特定值，因此可以使用二分查找。

![](https://pic.leetcode-cn.com/Figures/69/binary.png)

算法

如果 x < 2，返回 x。

令左边界为 2，右边界为 x / 2。

当 left <= right 时：

令 num = (left + right) / 2，比较 num * num 与 x：

* 如果 num * num > x，更新右边界为 right = pivot -1。

- 如果 num * num < x，更新左边界为 left = pivot + 1。

- 如果 num * num == x，即整数平方根为 num，返回 num。

最后返回 right。

class Solution {
  public int mySqrt(int x) {
    if (x < 2) return x;

    long num;
    int pivot, left = 2, right = x / 2;
    while (left <= right) {
      pivot = left + (right - left) / 2;
      num = (long)pivot * pivot;
      if (num > x) right = pivot - 1;
      else if (num < x) left = pivot + 1;
      else return pivot;
    }
    
    return right;
  }
}

