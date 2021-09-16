package homework;
import java.util.*;
public class homework32 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];
        int[] help = new int[n];
        for(int i = 0; i < n; i ++ ){
            nums[i] = scan.nextInt();
        }
        System.out.println(divide(nums, 0 , n - 1, help));
    }
    public static int divide(int[] list , int lo, int hi, int[] help){
        if(lo == hi){
            return 0;
        }
        int mid = (lo + hi) /2;
        int a = divide(list , lo, mid, help);
        int b = divide(list , mid + 1, hi, help);
        int count = 0;
        int i = lo, j = mid + 1, pos = lo;
        while(i <= mid && j <= hi){
            if(list[i] <= list[j]){
                help[pos ++ ] = list[i ++];
            }
            else{
                help[pos ++ ] = list[j ++ ];
                count += (mid - i + 1) ;
            }
        }
        while(j <= hi){
            help[pos ++ ] = list[j ++ ];
        }
        while(i <= mid){
            help[pos ++ ] = list[i ++ ];
        }
        for(int k = lo; k <= hi; k ++ ){
            list[k] = help[k];
        }
        return a + b + count;
    }
}
