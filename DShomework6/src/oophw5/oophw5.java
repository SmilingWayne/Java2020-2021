package oophw5;
import java.util.*;
public class oophw5 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        int x = a.length();
        int y = b.length();
        int[][] dp = new int[x][y];
        for(int i = 0; i < x ; i++){
            for(int j = 0; j < y ; j++){
                if(i == 0 && j == 0){
                    if(a.charAt(i) == b.charAt(j)){
                        dp[i][j] = 0;
                    }
                    else {
                        dp[i][j] = 1;
                    }
                }
                else if( i == 0 ){
                    if(a.charAt(i) == b.charAt(j)){
                        dp[i][j] = dp[i][j - 1];
                    }
                    else {
                        dp[i][j] = dp[i][j - 1] + 1;
                    }
                }
                else if( j == 0){
                    if(a.charAt(i) == b.charAt(j)){
                        dp[i][j] = dp[i - 1][j];
                    }
                    else {
                        dp[i][j] = dp[i - 1][j] + 1;
                    }
                }
                else {
                    if(a.charAt(i)!= b.charAt(j)){
                        dp[i][j] = Math.min(dp[i - 1][j],Math.min(dp[i][j - 1],dp[i - 1][j - 1])) + 1;
                    }
                    else if(a.charAt(i) == b.charAt(j)){
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        System.out.println(dp[x - 1][y - 1]);


    }


}
