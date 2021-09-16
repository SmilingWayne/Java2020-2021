package dp;

import java.util.*;
public class stockDeal1 {
    //trade single time
    public static void main(String[] args) {
        Random ran = new Random();

        Scanner scan = new Scanner(System.in);

        int total = scan.nextInt();

        int[] stock = new int[total];
        for(int i = 0 ; i < total; i ++ ){
            stock[i] = ran.nextInt(100);
        }
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for(int i = 0 ; i < total; i ++ ){
            if(i == 0){
                min = Math.min(min, stock[i]);
            }
            else{
                ans = Math.max(stock[i] - min, ans);
                min = Math.min(stock[i] , min);
            }
        }
        for(int i = 0 ; i < total ; i ++ ){
            System.out.print(stock[i] + " ");
        }
        System.out.println("最高收入为" + ans);
    }
}
