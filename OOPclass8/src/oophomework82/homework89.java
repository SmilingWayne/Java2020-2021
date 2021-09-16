package oophomework82;
import java.util.*;
public class homework89 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int total = scan.nextInt();
        int[] helper = new int[total];
        for (int i = 0; i < total; i++) {
            helper[i] = scan.nextInt();
        }
        scan.close();
        int res = 0;
        for(int i = 0; i < helper.length; i++){
            for(int j = i; j < helper.length; j++){
                if(helper[j] - helper[i] > 0){
                    res = Math.max(res,helper[j] - helper[i]);
                }
            }
        }
        int ans = maxProfit(helper);
        res = Math.max(res,ans);
        System.out.println(res);

    }
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }
        int[] f = new int[n];
        f[0] = 0;
        int min = prices[0];
        for (int i = 1; i < n; i++) {
            if (min > prices[i]) {
                min = prices[i];
            }
            f[i] = prices[i] - min;
        }
        int max = 0;
        int ans = f[n - 1];
        int value = 0;
        for (int i = n - 1; i > 0; i--) {
            if (prices[i] > max) {
                max = prices[i];
            }
            value = Math.max(value,max - prices[i]);
            ans = Math.max(ans, f[i - 1] + value);
        }
        return ans;
    }



}