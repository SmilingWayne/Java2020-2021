package oophw4;
import java.util.*;
public class oophw4 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] list = new int[m];
        for(int i = 0; i < m; i++){
            list[i] = scan.nextInt();
        }
        scan.close();

        int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int i = 0; i < list.length; i++){
            for(int j = 0; j + list[i]<= n; j++){
                dp[j + list[i]] += dp[j];
            }
        }
        System.out.println(dp[n]);
    }
}
