package homework;
import java.util.*;
public class homework33 {
    /*
    输出快排第m次排序的结果
    结果：已完成；
    测试数据：
    10 3
    52 49 80 36 14 58 61 97 23 75
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int times = scan.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i ++ ){
            nums[i] = scan.nextInt();
        }
        quicksort(nums, 0, nums.length - 1, times);
        for(int i = 0 ; i < n; i ++ ){
            System.out.print(nums[i] + " ");
        }
    }
    /*
    public static void exchange(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

     */
    public static int quicksort(int[] nums, int lo , int hi, int times){
        if(lo >= hi || judge(nums, lo, hi) || times <= 0){
            return times;
        }
        times -- ;
        int low = lo;
        int high = hi;
        int record = nums[lo];
        while(lo < hi){
            while(hi > lo && nums[hi] >= record){
                hi -- ;
            }
            nums[lo] = nums[hi];
            while(lo < hi && nums[lo] <= record){
                lo ++ ;
            }
            nums[hi] = nums[lo];
        }
        nums[lo] = record;
        int nextTimes = quicksort(nums, low, lo - 1, times);
        if(nextTimes <= 0){
            return nextTimes;
        }
        else{
            nextTimes = quicksort(nums, lo + 1, high, times);
        }
        return nextTimes;

    }
    public static boolean judge(int[] nums, int begin , int end){
        if(begin == end){
            return true;
        }
        for(int i = begin ; i <= end - 1; i++ ){
            if(nums[i] >= nums[i + 1]){
                return false;
            }
        }
        return true;
    }
}
