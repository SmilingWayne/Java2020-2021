package dp;

import java.util.*;

//能不能求出：给定操作次数，算出在这个周期内如何操作利润最大？


public class stockDeal4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int total = scan.nextInt();
        int times = scan.nextInt();
        int[] test = new int[total];
        for(int i = 0 ; i < total ; i ++ ){
            Random r = new Random();
            test[i] = r.nextInt(100);
        }
        for(Integer x : test){
            System.out.print(x + " ");
        }
        System.out.println("");
        int[] dp1 = getFirst(test);
        if(times == 1){
            int ans = 0;
            for(int i = 0 ;i < dp1.length; i ++ ){
                ans = Math.max(ans, dp1[i]);
            }
            System.out.println(ans);
        }
        else {
            int[] help = new int[dp1.length];
            for (int i = 0; i < times - 1; i++) {
                dp1 = getSecond(dp1, test);
                System.out.print(i + ":");
                display(dp1);
            }
            int ans = 0;
            for (int i = 0; i < dp1.length; i++) {
                ans = Math.max(dp1[i], ans);
            }
            System.out.println(ans);
        }
    }
    public static int[] getFirst(int[] a){
        int min = a[0];
        int[] dp = new int[a.length];
        for(int i = 1 ; i < a.length ; i ++ ){
            dp[i] = Math.max(dp[i - 1] , a[i] - min);
            min = Math.min(min, a[i]);
        }
        return dp;
    }
    public static void display(int[] a){
        for(int i = 0; i < a.length; i ++ ){
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }
    public static int[] getSecond(int[] a, int[] price){
        int max = a[price.length - 1];
        int[] dp = new int[a.length];

        for(int i = a.length - 2; i > 0 ; i -- ){
            dp[i] = Math.max(a[i], a[i - 1] - price[i] + max);
            max = Math.max(dp[i] , max);
        }
        return dp;
    }


}
