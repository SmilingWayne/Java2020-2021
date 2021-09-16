package javahw1;
import java.util.*;
public class javahw1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int maximum = scan.nextInt();
        int total = scan.nextInt();
        int[][] cargo = new int[total][2];
        for(int i = 0; i < total; i ++ ){
            cargo[i][0] = scan.nextInt();
            cargo[i][1] = scan.nextInt();

        }
        scan.close();

        boolean[] visited = new boolean[total];
        int[] dp = new int[maximum + 1];
        for(int i = 0; i < total; i ++ ){
            for(int j = maximum ; j >= cargo[i][0] ;j -- ){
                dp[j] = Math.max(dp[j], dp[j - cargo[i][0]] + cargo[i][1]);
            }
        }
        System.out.println(dp[maximum ]);

    }
}
