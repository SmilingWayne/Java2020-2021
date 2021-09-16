package javahw4;

import java.util.*;
public class javahw4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = scan.nextInt();
        scan.close();

        int[] dp = new int[number + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i < number + 1; i ++ ){
            if((int)Math.sqrt(i) == Math.sqrt(i)){
                dp[i] = 1;
            }
        }
        for(int i = 1; i < number + 1; i ++ ){
            if(i == 1){
                dp[i] = 1;
            }
            else if(i == 2){
                dp[i] = 2;
            }
            else{
                for(int j = 1; j <= i/ 2 ; j ++ ){

                    dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
                }
            }
        }
        //for(int i = 0 ; i < number +1 ; i ++ ){
          //  System.out.print(dp[i] + " ");
        //}
        System.out.println(dp[number]);
    }
}
