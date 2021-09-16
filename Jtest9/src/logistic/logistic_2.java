package logistic;
import java.util.*;

/**
 * 枚举法
 */
public class logistic_2 {
    public static void main(String[] args) {
        int[][] c = {{4,12,20,6},{2,10,25,10},{3,4,16,14},{6,5,9,2},{18,12,7,3},{14,4,4,9},{20,30,2,11},{24,12,6,22}};
        int[] d = {100,50,120,80,200,70,60,100};
        int target = 0;
        int[] choice = new int[2];
        int[] final_choice = new int[2];
        int final_target = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i ++ ){
            for(int j = i + 1; j < 4; j ++ ){
                choice[0] = i;
                choice[1] = j;
                target = 0;
                for(int k = 0 ; k < 8; k ++ ){
                    if(c[k][i] < c[k][j]){
                        target += c[k][i] * d[k];
                    }
                    else{
                        target += c[k][j] * d[k];
                    }
                }
                if(target < final_target){
                    final_target = target;
                    final_choice[0] = i;
                    final_choice[1] = j;
                }
            }
        }
        System.out.println("\t\t选择的物流中心: " + (final_choice[0] + 1) + " 和 " + (final_choice[1] + 1) + ".");
        System.out.println("\t\t" + "最少总成本: " + final_target + ".");
        for(int i = 0 ; i < 8; i ++ ){
            if(c[i][final_choice[0]] < c[i][final_choice[1]]){
                System.out.println("\t\t\t" + "第" + (i+1) + "个超市"  + "由 " + (final_choice[0] + 1)  + "物流中心运输" + d[i]);
            }
            else{
                System.out.println("\t\t\t" + "第" + (i+1) +"个超市"  + "由 " + (final_choice[1] + 1)  + "物流中心运输" + d[i]);
            }
        }


    }
}
