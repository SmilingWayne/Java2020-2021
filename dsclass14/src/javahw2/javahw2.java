package javahw2;
import java.util.*;
public class javahw2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int maxWeight = scan.nextInt();
        int maxVolume = scan.nextInt();
        int numbers = scan.nextInt();
        int[][] cargo = new int[numbers][4];

        for(int i = 0; i < numbers ; i ++ ){
            for(int j = 0 ; j < 4; j ++ ){
                cargo[i][j] = scan.nextInt();
            }
        }
        scan.close();
        Arrays.sort(cargo, (a,b)->{
            if(a[1] > b[1]){
                return 1;
            }
            return 0;
        });
        int[][] dp = new int[maxWeight + 1][maxVolume + 1];

        for(int i = 0; i < numbers; i ++ ){
            for(int j = 0; j < cargo[i][3] ; j ++ ){
                for(int k = maxWeight ; k >= cargo[i][0]; k --){
                    for(int m = maxVolume ; m >= cargo[i][1] ; m -- ){
                        dp[k][m] = Math.max(dp[k][m] , dp[k - cargo[i][0]][m - cargo[i][1]] + cargo[i][2]);
                    }
                }
            }
        }
        System.out.println(dp[maxWeight][maxVolume]);

    }
}
