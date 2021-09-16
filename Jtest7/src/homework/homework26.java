package homework;

import java.util.*;
public class homework26 {
    /*
    Not  finished!

     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int all = scan.nextInt();
        int target = scan.nextInt();
        int[] coins = new int[target];
        for(int i = 0 ; i < target; i ++ ){
            coins[i] = scan.nextInt();
        }
        int[][] dp = new int[target + 1][all + 1];
        Arrays.sort(coins);
        for(int i = 0 ; i <= all ; i ++ ){
            dp[0][i] = 1;
        }
        for(int i = 1 ; i <= target ; i ++ ){
            for(int j = 1; j <= all; j ++ ){
                dp[i][j] = 0;
                for(int k = 0 ; k <= j/coins[i - 1] ; k ++ ){
                    dp[i][j] += dp[ i - 1][j - k * coins[i - 1]];
                }
            }
        }
        for(int i = 0 ; i < target + 1; i ++ ){
            for(int j = 0 ; j < all + 1; j ++ ){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println(dp[target][all]);

    }
}
