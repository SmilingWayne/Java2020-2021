package minPerfSqrt;
import java.util.*;
public class minPerSqrt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int ans = scan.nextInt();
        int[] dp = new int[ans + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1 ; i < dp.length ; i ++ ){
            if(i == 1){
                dp[i] = 1;
            }
            else{
                int x = (int)Math.sqrt(i);
                if(i == x*x){
                    dp[i] = 1;
                }
                else{
                    for(int j = i - 1; j >= i / 2; j -- ){
                        dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
                    }
                }
            }

        }
        System.out.println(dp[ans]);
    }
}
