package selectSort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class selectsort {
    public static void main(String[] args){
        int arr[] = {5,3,2,7,4,2,95,34};
        selectSort(arr);
    }
    public static void selectSort(int[] arr){
        int flag = 0;
        for(int i = 0 ; i < arr.length-1; i++){
            flag = i;
            for(int j = i+1 ; j<arr.length; j++){
                if(arr[j]<arr[flag]){
                    flag = j;
                }
            }
            int change = arr[i];
            arr[i] = arr[flag];
            arr[flag] = change;
        }
        System.out.println(Arrays.toString(arr));
    }
}
