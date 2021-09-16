package homework;
import java.util.*;
public class homework31 {
    /*
    动态规划/ 分治算法求解最大连续子数组的和
    测试数据：
    9
    -2 1 -3 4 -1 2 1 -5 4
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int[] list = new int[a];
        for(int i =  0 ; i < a; i ++ ){
            list[i] = scan.nextInt();
        }
        System.out.println(maxSuccessiveArrayTwo(list));
    }
    public static int maxSuccessiveArrayOne(int[] list){
        int n = list.length;
        int[] dp = new int[n];
        for(int i = 0 ; i < n; i ++ ){
            if(i == 0){
                dp[i] = Math.max(0, list[i]);
            }
            else{
                int add = Math.max(0, dp[i - 1]);
                dp[i] = Math.max(add + list[i], 0);
            }
        }
        int res = dp[0];
        for(int i = 0 ; i < n ; i ++){
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    /*
    Divide and conquer:
     */
    public static int maxSuccessiveArrayTwo(int[] list){
        return divide(list, 0, list.length - 1);
    }
    public static int divide(int[] list , int lo , int hi){
        if(lo == hi){
            return list[lo];
        }
        int mid = (lo + hi)/2;
        int front = divide(list , lo, mid);
        int post = divide(list, mid + 1, hi);
        int record = Math.max(front, post);
        int back = mid + 1;
        int pre = mid;
        int temp = 0;
        while(pre >= 0 && back <= hi){
            temp += Math.max(list[pre], list[back]);
            if(list[pre] >= list[back]){
                pre --;
            }
            else{
                back ++ ;
            }
            record = Math.max(record, temp);
        }
        while(pre >= 0){
            temp += list[pre -- ];
            record = Math.max(record, temp);
        }
        while(back <= hi){
            temp += list[back ++ ];
            record = Math.max(record, temp);
        }
        return record;
    }
}
