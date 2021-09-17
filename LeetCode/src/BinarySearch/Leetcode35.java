package BinarySearch;
import java.util.*;
public class Leetcode35 {
    public static void main(String[] args) {
        Solution_35_1 sol = new Solution_35_1();
        System.out.println(sol.searchInsert(new int[]{1,4,5,6,11,24,55}, 7));
    }
}

class Solution_35_1 {
    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        int low = 0, high = length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] > target){
                high = mid - 1;
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }
            else{
                return mid;
            }
        }
        return high + 1;
    }
};
