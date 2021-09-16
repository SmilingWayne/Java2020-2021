package insertSort;

import java.util.Arrays;

public class insertSort {
    public static void main(String[] args){
        int[] arr = {8,9,1,7,2,3,5,4,6,0};
        shellSort(arr);
    }
    public static void insert(int[] arr){
        for(int i = 1;i<arr.length;i++){
            int insertVal = arr[i];
            int insertIndex = i -1;
            while(insertIndex >= 0 &&insertVal < arr[insertIndex]){
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
            if(insertIndex+1!=i)
                arr[insertIndex+1]=insertVal;
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void shellSort(int[] arr){
        for(int length = arr.length/2; length>0;length/=2) {
            for (int i = length ; i < arr.length; i++) {
                for (int j = i - length; j >= 0; j -= length) {
                    if (arr[j] > arr[j + length]) {
                        int temp = arr[j];
                        arr[j] = arr[j + length];
                        arr[j + length ] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
//怎么理解：假象有一个有序表，逐渐开始向里面加内容进去//