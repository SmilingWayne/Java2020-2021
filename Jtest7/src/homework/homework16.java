package homework;

import java.util.*;
public class homework16 {
    public static void main(String[] args) {
        /*
        LCS 问题：
         */
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        String t = scan.next();
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0 ; i < m + 1; i ++ ){
            for(int j = 0 ;j < n + 1; j++ ){
                dp[i][j] = 0;
            }
        }
        for(int i = m - 1; i >=0 ; i --  ){
            for(int j = n - 1; j >= 0 ; j -- ){
                if(s.charAt(i) == t.charAt(j)){
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        String lcs ="";
        int i = 0 ;
        int j = 0;
        while(i < m && j < n){
            if(s.charAt(i) == t.charAt(j)){
                lcs += s.charAt(i);
                i ++ ;
                j ++ ;
            }
            else if(dp[i + 1][j] >= dp[i][j + 1]){
                    i ++ ;
            }
            else{
                j ++ ;
            }
        }
        System.out.println(lcs.length());
        System.out.println(lcs);
    }
}
