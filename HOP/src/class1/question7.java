package class1;//package class1;
import java.util.*;
public class question7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int W = scan.nextInt();
        int V = scan.nextInt();
        int n = scan.nextInt();
        int[][] items = new int[n][4];
        for(int i = 0; i < n ; i ++ ){
            for(int j = 0; j < 4; j ++ ){
                items[i][j] = scan.nextInt();
            }
        }

        int[][] dp = new int[W + 1][ V + 1];
        for(int i = 0 ; i <= W ; i++ ){
            for(int j = 0 ; j <= V ; j ++ ){
                dp[i][j] = 0;
            }
        }
        for(int i = 0 ; i < n ; i ++ ){
            for(int j = 0 ; j < items[i][3] ; j ++ ){
                for(int k = W ; k >= items[i][0] ; k -- ){
                    for(int l = V ; l >= items[i][1] ; l --){
                        dp[k][l] = Math.max(dp[k - items[i][0]][l - items[i][1]] + items[i][2], dp[k][l]);
                    }
                }
            }
        }
        System.out.println(dp[W][V]);
    }
}
