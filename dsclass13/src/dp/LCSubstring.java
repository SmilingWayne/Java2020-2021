package dp;
import java.util.*;
public class LCSubstring {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String str1 = scan.next();
        String str2 = scan.next();
        int strlen1 = str1.length();
        int strlen2 = str2.length();
        int ans = 0;
        int[][] dp = new int[strlen1 + 1][strlen2 + 1];
        for(int i = 0 ; i < dp.length ; i ++ ){
            for(int j = 0  ;j < dp[0].length ; j ++ ){
                if(i == 0 || j == 0){
                    continue;
                }
                if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(dp[i][j] , ans);
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        System.out.println("最长公共子串是" + ans);
    }
}
