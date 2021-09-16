package homework;
import java.util.*;
public class homework21 {
    /*
    DP :Multiple Machine Problem
    两台机器，同时生产一批零部件，问总生产时间最短是多少？
    GG
    没有做出：N台机器同时生产一批零部件，生产时间最短是多少？
    GG

    这里多组无法使用动态规划了把？

     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int total = scan.nextInt();
        int[] list = new int[total + 4];
        int all = 0;
        for(int i = 0 ; i < total + 4 ; i ++ ){
            if(i == 0 || i == 1 || i == 2 || i == 3){
                list[i] = 0;
            }
            else {
                list[i] = scan.nextInt();
                all += list[i];
            }
        }
        int[][] dp = new int[total + 5][all + 1];
        for(int i = 0 ; i <= total + 4; i ++ ){
            for(int j = 0 ; j <= all ; j ++ ){
                if(i == 0 || i == 1 || i == 2 || i == 3){
                    dp[i][j] = 0;
                }
                else{
                    for(int z = 1 ; z <= 4; z ++ ) {
                        if ( j < list[i - z]) {
                            dp[i][j] = dp[i - z][j];
                        } else {
                            dp[i][j] = Math.max(dp[i - z][j], Math.max(dp[i - z][j - list[i - z]] + list[i - z], dp[i][j]));
                        }
                    }
                }
            }
        }
        for(int i = 0  ; i < total + 5; i ++ ){
            for(int j = 0; j < all + 1; j ++ ){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println("");
        }
        int machine = 4;
        int res = 0;
        for(int i = 0 ; i <= (all/machine) + 1; i ++ ){
            res = Math.max(res, dp[dp.length - 1][i]);
        }
        System.out.println(res);
//        dp(list, all, 4);

    }
    public static void dp(int[] list, int all, int machine){
        int[] op = new int[all + 1];
        for(int i = 0 ; i < list.length; i ++ ){
            for(int j = 0 ; j <= all; j ++ ){
                if(j < list[i]){
                    continue;
                }
                else{
                    op[j] = Math.max(op[j - list[i]] + list[i], op[j]);
                }
            }
        }
        int[] help = new int[machine];
        Arrays.fill(help,0);
        int start = 0;
        for(int i = 0 ; i < machine; i ++ ){
            for(int j = start; j <= (all * (i + 1))/ machine ; j ++ ){
                help[i] = Math.max(help[i], op[j]);
            }
            //System.out.println(help[i] + "!!");
            start = (all * (i + 1)/ machine) + 1;
        }
        for(int i = machine - 1; i > 0 ;i -- ){
            help[i] -= help[i - 1];
        }
        int res = 0;
        for(int i = 0 ; i < machine; i ++ ){
            res = Math.max(res, help[i]);
        }
        System.out.println(res);
    }
}
