package DataStromework5;
import java.util.*;

/**
 * 动态规划求解LCS 最长公共子串问题
 */

public class datastrhomework5 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String total = scan.nextLine();
        String[] helper = total.split(" ");
        String t ="";
        String s ="";
        scan.close();
        for(int i = 0 ; i < helper.length; i++){
            if(!helper[i].equals(" ")){
                t = helper[i];
                for(int j = i+1;j<helper.length; j++){
                    if(!helper[j].equals("")){
                        s = helper[j];
                        break;
                    }
                }
                break;
            }
        }
        System.out.println(findNumber(t,s));

    }
    // java 动态规划求解LCS问题：
    public static int findNumber(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c1 = str1.charAt(i);
                char c2 = str2.charAt(j);
                if (c1 == c2) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
            return dp[m][n];

    }
}
