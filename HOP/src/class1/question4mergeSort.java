package class1;
import java.util.*;
public class question4mergeSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] array = new int[n];
        for(int i = 0 ; i < n ; i ++ ){
            array[i] = scan.nextInt();
        }
        sort(array);
        for(int i = 0; i < n; i ++ ){
            System.out.print(array[i] + " ");
        }
    }
    public static void sort(int[] array){
        int[] a = new int[array.length];
        mergeSort(array, 0, array.length - 1, a);
    }
    public static void mergeSort(int[] array, int a, int b, int[] c){
        if(a < b){
            int mid = (a + b) /2;
            mergeSort(array, a, mid, c);
            mergeSort(array, mid + 1, b, c);
            merge(array, a, mid , b, c);
        }
    }
    public static void merge(int[] array, int pre , int mid ,int post , int[] temp){
        int i = pre;
        int j = mid + 1;
        int t = 0;
        while(i <= mid && j <= post){
            if(array[i] >= array[j] ){
                temp[t ++ ] = array[i ++];
            }
            else{
                temp[t ++ ] = array[j ++ ];
            }
        }
        while(i <= mid){
            temp[t ++ ] = array[i ++ ];
        }
        while(j <= post){
            temp[t ++ ] = array[j ++ ];
        }
        t = 0;
        while(pre <= post){
            array[pre ++] = temp[t ++ ];
        }
    }

}
