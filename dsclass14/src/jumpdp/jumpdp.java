package jumpdp;
import java.util.*;
public class jumpdp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int total = scan.nextInt();

        int[] dp = new int[total + 1];

        dp[1] = 1;
        for(int i = 2; i < total + 1; i ++ ){

            dp[i] = dp[i - 1] + dp[i - 2];
        }

    }
}
