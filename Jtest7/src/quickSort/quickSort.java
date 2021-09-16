package quickSort;
import java.util.*;
public class quickSort {
    public static void main(String[] args) {
        int[] arr = {-9,-78,0,23,-567,70};
        sort(arr,0,arr.length-1);
        System.out.print(Arrays.toString(arr));
    }
    public static void sort(int[] arr,int left, int right){
        int r = right;
        int l = left;
        int pivot = arr[(l + r)/2];
        int temp = 0;//临时变量//
        while(l < r){
            while( arr[l] < pivot){
                l++;
            }
            while( arr[r] > pivot){
                r--;
            }
            if(l >=r ){
                break;
            }
            else{
                temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
            if(arr[l] == pivot){
                r-=1;
            }
            if(arr[r] == pivot){
                l+=1;
            }
        }
        if(l == r){
            l+=1;
            r-=1;
        }
        if(left < r)
            sort(arr,left,r);
        if(right > l)
            sort(arr,l,right);
    }
}
