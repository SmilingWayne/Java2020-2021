package dp;

import java.util.*;

public class stockDeal3 {
    public static void main(String[] args) {
        /*Random ran = new Random(1);

        Scanner scan = new Scanner(System.in);

        int total = scan.nextInt();

        int[] stock = new int[total];
        for(int i = 0 ; i < total; i ++ ){
            stock[i] = ran.nextInt(100);
        }

         */
        int[] stock = {85 ,88, 47, 13, 54 ,4 ,34, 6};
        int total = stock.length;
        System.out.println(maxProfit(stock));
    }
    public static int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        int min = prices[0];
        for(int i = 1 ; i < prices.length; i ++ ){
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
            min = Math.min(min , prices[i]);
        }
        int max = prices[prices.length - 1];
        int ans = dp[dp.length - 1];
        for(int i = dp.length - 2; i > 0; i -- ){
            ans = Math.max(ans, max - prices[i] + dp[i - 1]);
            max = Math.max(max, prices[i]);
        }
        return ans;
    }

}
