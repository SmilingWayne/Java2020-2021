package dp;

import java.util.*;

public class minEditDIstance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.next();
        String str2 = scan.next();
        int strlen1 = str1.length();
        int strlen2 = str2.length();
        int[][] dp = new int[strlen1 + 1][strlen2 + 1];
        for(int i = 0 ; i < dp.length; i ++ ){
            dp[i][0] = i;
        }
        for(int i = 0; i < dp[0].length; i ++ ){
            dp[0][i] = i;
        }
        for(int i = 1 ; i < dp.length; i ++ ){
            for(int j = 1; j < dp[0].length; j ++ ){
                if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] ));
                }
                else{
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1 ));
                }
            }
        }
        System.out.println(dp[strlen1][strlen2]);
        //System.out.println(method2(str1, str2));
    }
    public static int method2(String str1, String str2){
        int strlen1 = str1.length();
        int strlen2 = str2.length();
        int x = Math.abs(strlen1 - strlen2);
        int[][] lcs = new int[strlen1 + 1][strlen2 + 1];
        for(int i = 0 ; i < lcs.length ; i ++ ){
            for(int j = 0 ; j < lcs[0].length; j ++ ){
                if( i == 0 || j == 0){
                    lcs[i][j] = 0;
                }
                else{
                    if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                        lcs[i][j] = lcs[i - 1][j - 1] + 1;
                    }
                    else{
                        lcs[i][j] = Math.max(lcs[i - 1][j] , lcs[i][j - 1]);
                    }
                }
            }
        }
        return -lcs[strlen1][strlen2] + Math.max(strlen1, strlen2);
    }
    //该方法不行，具体看execution和intention 的例子！


}
