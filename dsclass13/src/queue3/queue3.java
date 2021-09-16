package queue3;

import java.io.File;
import java.util.*;

public class queue3 {
    public static void main(String[] args) {
        //File file = new File("src/queue3/data");

            Scanner scan = new Scanner(System.in);
            int x = scan.nextInt();
            int[] dp = new int[x];
            for(int i = 0 ; i < x ; i ++ ){
                dp[i] = scan.nextInt();
            }
            int start = scan.nextInt();
            int end = scan.nextInt();
            int[] ans = new int[x];
            if(start >= end) {
                for (int i = 0; i < start; i++) {
                    ans[i] = dp[x - start + i];
                }
                for (int i = start; i < x - end; i++) {
                    ans[i] = dp[i - start + end];
                }
                for (int i = x - end; i < x; i++) {
                    ans[i] = dp[end + i - x];

                }
                for (int i = 0; i < x; i++) {
                    System.out.println(ans[i] + " .");
                }
            }
            else if(start < end){

            }

    }
}
