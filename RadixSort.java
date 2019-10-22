import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = new int[] {3,4,7,5,2,0,8,1,9,6};
        RadixSort.RadixSort(arr);
        System.out.println(Arrays.toString(arr));

    }
    public static void RadixSort(int[] arr){
    	// 选取最大的数字，默认为数组第一个元素
        int max = arr[0];
        // 查找最大的数字
        for(int i=1;i<arr.length;i++){
            if (arr[i]>max){
                max = arr[i];
            }
        }
        // 最大的数字位数
        int maxLength = (max+"").length();
        // 设置十个队列用来存储基数相同的元素
        int[][] queue = new int[10][arr.length];
        // 为每个队列设置索引标记每个队列里有多少元素
        int[] queueIndex = new int[10];
        // 总共循环最大数字位数
        for(int i=1,n=1;i<=maxLength;i++,n*=10){
        	// 遍历数组中全部元素，将每个元素放入对应基数相同的队列
            for(int j=0;j<arr.length;j++){
                int ys = arr[j]/n%10;
                queue[ys][queueIndex[ys]] = arr[j];
                queueIndex[ys] += 1;
            }
            // 遍历全部基数队列，按从0-9顺序，先进先出地取出全部元素替换原来数组元素。
            int arrIndex = 0;
            for(int k=0;k<10;k++){
                for(int l=0;l<queueIndex[k];l++){
                    arr[arrIndex] = queue[k][l];
                    arrIndex += 1;
                }
            }
        }
    }
}