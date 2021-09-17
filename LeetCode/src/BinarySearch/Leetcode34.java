package BinarySearch;
import java.util.*;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 * 进阶：
 * 你可以设计并实现时间复杂度为O(log n)的算法解决此问题吗？
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode34 {
    public static void main(String[] args) {
        Solution_34_1 sol = new Solution_34_1();
        int[] ans = sol.searchRange(new int[]{5,7,7,8,8,10}, 8);
        for(Integer i : ans){
            System.out.println((i));
        }
    }
}

/**
 * 解释：因为可能出现多个节点，
 */
class Solution_34_1 {
    public int[] searchRange(int[] nums, int target) {

        int minIndex = nums.length - 1;
        int maxIndex = 0;

        int left = 0;
        int right = nums.length - 1;
        int mid ;
        while (left <= right) {
            mid = (left + right) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]){
                right = mid - 1;
            } else {
                // 找到了target，但是target可以有多个，所以进行遍历
                maxIndex = mid;
                minIndex = mid;
                // 向后遍历得到maxIndex
                for (int i = mid; i <= nums.length - 1 && nums[i] == target; i++) {
                    maxIndex = Math.max(maxIndex, i);
                }
                // 向前遍历得到minIndex
                for (int i = mid; i >= 0 && nums[i] == target; i--) {
                    minIndex = Math.min(minIndex, i);
                }
                return new int[] {minIndex, maxIndex};
            }
        }
        return new int[] {-1, -1};
    }
}