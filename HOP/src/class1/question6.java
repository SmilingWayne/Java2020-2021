package class1;
import java.util.*;
public class question6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sack = scan.nextInt();
        int n = scan.nextInt();
        int[][] items = new int[n][2];
        for(int i = 0 ; i < n ; i ++ ){
            items[i][0] = scan.nextInt();
            items[i][1] = scan.nextInt();
        }
        int[] dp = new int[ sack + 1];
        Arrays.fill(dp, 0);
        for(int i = 0 ; i < n; i ++ ){
            for(int j = sack ;  j >= items[i][0] ; j -- ){
                dp[j] = Math.max(dp[j - items[i][0]] + items[i][1], dp[j]);
            }
        }
        System.out.println(dp[sack]);

    }
}
