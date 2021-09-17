package BinarySearch;
import java.util.*;

/**
 * -------------------------------确定目标值位置-------------------------------
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
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
