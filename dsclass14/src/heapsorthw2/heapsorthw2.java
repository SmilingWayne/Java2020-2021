package heapsorthw2;

import java.util.*;

public class heapsorthw2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int all = scan.nextInt();
        int times = scan.nextInt();
        int[] total = new int[all];
        for(int i = 0 ; i < all ; i ++ ){
            total[i] = scan.nextInt();
        }
        scan.close();
        sort(total, times);
        for(int i = 0; i < total.length; i ++){
            System.out.print(total[i] + " ");
        }

        /*sort(arr);

        for(int i = 0 ; i < arr.length ; i ++ ){
            System.out.print(arr[i] + " ");
        }

         */

    }
    public static boolean judge(int[] arr){
        boolean ans = true;
        if(arr.length == 1){
            return true;
        }
        for(int i = 1 ; i < arr.length ; i ++ ){
            if(arr[i] < arr[i - 1]){
                ans = false;
                break;
            }
        }
        return ans;
    }
    public static void sort(int[] arr, int times){
        if(times <= 0 || judge(arr) == true){
            return;
        }
        for(int i = arr.length/2 - 1; i >=0 ; i -- ){
            adjustHeap(arr, i, arr.length);
        }
        times -- ;
        if(judge(arr) == true){
            return;
        }
        if(times <= 0){
            swap(arr, 0, arr.length - 1);
            return;
        }
        for(int j = arr.length - 1; j > 0; j --){

            swap(arr, 0, j);
            if(judge(arr) == true || times <= 0){
                break;
            }
            adjustHeap(arr , 0 , j);
            times --;
        }
    }
    public static void adjustHeap(int[] arr, int i , int length){
        int temp = arr[i];
        for(int k = i *2 + 1; k < length ; k = k * 2 + 1){
            if(k + 1 < length && arr[k] < arr[k + 1]){
                k ++ ;
            }
            if(arr[k] > temp){
                arr[i] = arr[k];
                i = k;
            }
            else{
                break;
            }
        }
        arr[i] = temp;
    }
    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
