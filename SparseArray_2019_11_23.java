package com.chanshy.dataStructure;

public class SparseArray_2019_11_23 {

    public int[][] arr;
    int[][] sparseArr;

    public SparseArray_2019_11_23(int row, int column) {
        this.arr = new int[row][column];
    }

    public SparseArray_2019_11_23(){
        this(11,11);
    }

    public void printArr(int[][] arr){
        for (int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.printf("%d\t", arr[i][j]);
            }
            System.out.println();
        }
    }

    public void printArr(){
        printArr(this.arr);
    }

    public void printSparseArr(){
        for (int i=0;i<sparseArr.length;i++){
            for(int j=0;j<sparseArr[i].length;j++){
                System.out.printf("%d\t", sparseArr[i][j]);
            }
            System.out.println();
        }
    }

    public void setAttribute(int i, int j, int num){
        arr[i][j] = num;
    }

    public void toSparseArr() {
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]!=0){
                    sum++; // 遍历数组，计算非零数据的个数
                }
            }
        }
        sparseArr = new int[sum+1][3];
        sparseArr[0][0] = arr.length;
        sparseArr[0][1] = arr[0].length;
        sparseArr[0][2] = sum;
        int count = 0; // 计数，直到系数矩阵存储了所有原矩阵中非零数据
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]!=0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = arr[i][j];
                }
            }
        }
        printSparseArr();
    }

    public void sparseArrayToArr(){
        int[][] newArr = new int[sparseArr[0][0]][sparseArr[0][1]];
        for(int i=0,i1=1;i<newArr.length;i++){ // i1遍历稀疏数组
            for(int j=0;j<newArr[i].length;j++){
                if (i1<=sparseArr[0][2]) {
                    if (sparseArr[i1][0] == i && sparseArr[i1][1] == j) {
                        newArr[i][j] = sparseArr[i1][2];
                        i1++;
                    }
                }
            }
        }
        printArr(newArr);
    }
}
