package BinarySearch;
import java.util.*;

/**
 * 给你一个非负整数 x ，计算并返回的 平方根 。
 *
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 *
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode69 {
    public static void main(String[] args) {
        Solution_69_1 sol = new Solution_69_1();
        System.out.println(sol.mySqrt(54));
    }
}

class Solution_69_1 {
    public int mySqrt(int x) {
        if(x == 1){
            return 1;
        }
        int min = 0;
        int max = x;
        while(max - min > 1){
            int m = (max + min)/2;
            if(x / m < m)
                max = m;
            else{
                min = m;
            }
        }
        return min;
    }
}