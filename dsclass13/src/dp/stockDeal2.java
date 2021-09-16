package dp;

import java.util.*;

public class stockDeal2 {
    //unlimited trading times
    public static void main(String[] args) {
        Random ran = new Random(1);

        Scanner scan = new Scanner(System.in);

        int total = scan.nextInt();

        int[] stock = new int[total];
        for(int i = 0 ; i < total; i ++ ){
            stock[i] = ran.nextInt(100);
        }
        int min = Integer.MAX_VALUE;
        int ans = 0;
        int dp0 = 0;
        int dp1 = -stock[0];
        for(int i = 0 ; i < total; i ++ ){
            int newdp0 = Math.max(dp0, dp1 + stock[i]);
            int newdp1 = Math.max(dp1, dp0 - stock[i]);
            dp0 = newdp0;
            dp1 = newdp1;
        }
        for(int i = 0 ; i < total; i ++ ){
            System.out.print(stock[i] + " ");
        }
        System.out.println("最高收入为 " + dp0);
    }
}
