package demo;



public class MaxSubsequence {
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
//        int[] arr = {-2,-1,-3,-4,-1,-2,-1,-5,-4};
        System.out.println(method4(arr));
    }


    // O(N^3)复杂度揭解法
    private static int method1(int[] arr) {
        int maxSum = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                int thisSum = 0;
                for(int k=i;k<=j;k++){
                    thisSum += arr[k];

                }
                if(thisSum > maxSum){
                    maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }

    // O(N^2)复杂度解法
    private static int method2(int[] arr) {
        int maxSum = 0;
        for(int i=0;i<arr.length;i++){
            int thisSum = 0;
            for(int j=i;j<arr.length;j++){
                thisSum += arr[j];
                if(thisSum > maxSum){
                    maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }

    // O(N*logN)复杂度解法  ---  分治思想
    // {-2,1,-3,4,-1,2,1,-5,4}
    // {-2,1,-3,4}   {-1,2,1,-5,4}

    private static int method3(int[] arr, int left, int right) {
        // 基准条件
        if (left == right) {
            if (arr[left] > 0){
                return arr[left];
            }
            else{
                return 0;
            }
        }

        int center = (left + right) / 2;
        int maxLeftSum = method3(arr, 0, center);
        int maxRightSum = method3(arr, center + 1, right);

        int maxLeftBorderSum = 0, leftBorderSum = 0;

        for(int i=center; i>=left; i--){
            leftBorderSum += arr[i];
            if (leftBorderSum > maxLeftBorderSum) {
                maxLeftBorderSum = leftBorderSum;
            }
        }

        int maxRightBorderSum = 0, rightBorderSum = 0;
        for(int i=center+1; i<=right;i++){
            rightBorderSum += arr[i];
            if (rightBorderSum > maxRightBorderSum) {
                maxRightBorderSum = rightBorderSum;
            }
        }

        return max3(maxRightSum, maxLeftSum, maxLeftBorderSum+maxRightBorderSum);
    }
    private static int method3(int[] arr){
        return method3(arr, 0, arr.length-1);
    }
    private static int max3(int a, int b, int c) {
        if(a>=b&&a>=c){
            return a;
        }
        if(b>=a&&b>=c){
            return b;
        }
        if(c>=a&&c>=b){
            return c;
        }
        else return 0;
    }


    // 对于全负数的数组无效
    private static int method4(int[] arr){
        int maxSum = 0, thisSum = 0;
        for(int j=0;j<arr.length;j++){
            thisSum += arr[j];

            if(thisSum>maxSum){
                maxSum = thisSum;
            }

            else if(thisSum < 0){
                thisSum = 0;
            }
        }
        return maxSum;
    }
}
