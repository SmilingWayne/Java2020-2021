
package dchomework2;
import java.util.*;
public class dchomework2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int total = scan.nextInt();
        int[] list = new int[total];
        for(int i = 0; i < total; i ++ ){
            list[i] = scan.nextInt();
        }
        scan.close();
        int[] dp = new int[total];
        for(int i = 0; i < total; i ++ ){
            if(i == 0){
                dp[i] = list[i];
            }
            else{
                dp[i] = Math.max(dp[i - 1], 0) + list[i];
            }
        }
        int res = list[0];
        for(int i = 0; i < total; i ++ ){
            res = Math.max(res, dp[i]);
        }
        System.out.println(res);
    }
}
